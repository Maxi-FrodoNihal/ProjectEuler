package util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DLoader {

	public static <T, A> List<T> loadInterfaceObjectsFromT(Class<A> ankerClass, Class<T> interfaceClass) {

		List<T> listOfAllImplementedObjects = new ArrayList<>();

		try {

			List<String> findClasses = findClasses(new File(getJarDirName()), ankerClass.getPackage());

			for (String tmpClassName : findClasses) {

				String realClassName = getClassName(tmpClassName);
				final Class<?> classType = Class.forName(realClassName);

				if (interfaceClass.isAssignableFrom(classType) && interfaceClass.isInterface()) {
					Constructor<?> simpleCon = classType.getConstructor();
					T InterfaceObject = (T) simpleCon.newInstance();
					listOfAllImplementedObjects.add(InterfaceObject);
				}
			}

		} catch (IOException | ClassNotFoundException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfAllImplementedObjects;
	}

	/**
	 * Ermittelt alle Laufklassen aus dem aktuellen Packet.
	 *
	 * @param source Namen des aktuellen JAR's oder des Klassenverzeichnisses
	 * @param ap     Verzeichnis, in dem sich die Läufe befinden
	 *
	 * @return Eine Liste aller Klassen, nie <i>null</i>.
	 *
	 * @throws IOException Wenn nicht auf <b>source</b> zugegriffen werden kann.
	 */
	private static List<String> findClasses(final File source, final Package ap) throws IOException {
		if (source.isDirectory() && !source.getName().endsWith(".jar")) {
			return findClassesDirectory(source, ap);
		}
		return findClassesJar(source, ap);
	}

	/**
	 * Sucht alle Klassen im übergebenen Verzeichnis deren Packet mit dem
	 * übergebenen Packetnamen beginnen.
	 *
	 * @param source Der Filepointer zum Verzeichnis, nicht <code>null</code>.
	 * @param ap     Das Packet, welches durchsucht wird, nicht <code>null</code>.
	 * @return Die Namen aller Klassen in diesem Package, nicht <code>null</code> .
	 * @throws IOException wenn nicht auf das Verzeichnis zugegriffen werden konnte.
	 * @since 1.0.0
	 */
	private static List<String> findClassesDirectory(final File source, final Package ap) throws IOException {
		final List<String> abfragenamen = new ArrayList<>(20);
		if (source.isDirectory()) {
			final File packageDir = new File(source, ap.getName().replaceAll("\\.", "/"));
			addClassesDirectory(packageDir, ap.getName(), abfragenamen);
		}
		return abfragenamen;
	}

	/**
	 * Gibt den Namen des aktuellen JAR's oder des Klassenverzeichnisses zurück.
	 *
	 * @return <code>null</code>, wenn der Name nicht ermittelt werden konnte.
	 * @since 1.0.0
	 */
	private static String getJarDirName() {
		final String classpath = "/" + DLoader.class.getName().replaceAll("\\.", "/") + ".class";
		final URL url = DLoader.class.getResource(classpath);
		if (url == null) {
			return null;
		}
		String urls = url.toString();
		try {
			urls = URLDecoder.decode(url.toString(), "UTF-8");
		} catch (final UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if (urls.startsWith("file:")) {
			// Der Export wird nicht aus einem JAR ausgeführt. Es könnte sich um
			// einen Unittest handeln.
			// urls:
			// file:/C:/hsh/workspace/hsh-ireg-export/target/classes/de/hshsoft/ireg/xmlexport/abfragen/BaseExport.class
			final String buffer = urls.substring(5, urls.indexOf("/classes/") + 9);
			// buffer: /C:/hsh/workspace/hsh-ireg-export/target/classes/
			return buffer;
		}
		String buffer = urls.substring(10, urls.indexOf('!'));
		if (buffer.charAt(0) != '/') {
			buffer = "/" + buffer;
		}

		return buffer;
	}

	/**
	 * Sucht alle Klassen im übergebenen JAR deren Packet mit dem übergebenen
	 * Packetnamen beginnen.
	 *
	 * @param source Der Filepointer zum Export-Jar, nicht <code>null</code>.
	 * @param ap     Das Packet, welches durchsucht wird, nicht <code>null</code>.
	 * @return Die Namen aller Klassen in diesem Package, nicht <code>null</code> .
	 * @throws IOException wenn nicht auf das JAR zugegriffen werden konnte.
	 * @since 1.0.0
	 */
	private static List<String> findClassesJar(final File source, final Package ap) throws IOException {
		final List<String> abfragenamen = new ArrayList<>(20);
		final ZipFile zipFile = new ZipFile(source);
		final Enumeration<? extends ZipEntry> entries = zipFile.entries();
		final String pname = ap.getName().replaceAll("\\.", "/");
		while (entries.hasMoreElements()) {
			final ZipEntry zipEntry = entries.nextElement();
			if (!zipEntry.isDirectory() && zipEntry.getName().startsWith(pname)
					&& zipEntry.getName().endsWith(".class")) {
				// if (BaseExport.LOGGER.isDebugEnabled())
				// BaseExport.LOGGER.debug("Name Abfrageklasse: "+zip_entry.getName());
				abfragenamen.add(zipEntry.getName());
			}
		}

		zipFile.close();
		return abfragenamen;
	}

	/**
	 * Ermittelt alle Klassen im übergebenen Verzeichnis und allen
	 * Unterverzeichnissen und fügt diese der übergebenen Liste hinzu.
	 *
	 * @param packageDir   Das Verzeichnis, in welchem nach Klassen gesucht werden
	 *                     soll, nicht <code>null</code>. Alle Unterverzeichnisse
	 *                     werden ebenfalls durchsucht.
	 * @param packageName  Der Name des aktuellen Pakete, nicht <code>null</code>.
	 * @param abfragenamen Die Liste der Namen der gefundenen Klassen, nicht
	 *                     <code>null</code>.
	 * @since 1.0.0
	 */
	private static void addClassesDirectory(final File packageDir, final String packageName,
			final List<String> abfragenamen) {
		if (packageDir.isDirectory()) {
			final File[] files = packageDir.listFiles();
			for (final File file : files) {
				if (file.isDirectory()) {
					addClassesDirectory(file, packageName + "." + file.getName(), abfragenamen);
				} else if (file.getName().endsWith(".class")) {
					abfragenamen.add(packageName + "." + file.getName());
				}
			}
		}
	}

	/**
	 * Erzeugt aus dem übergebenen Dateinamen eine Java-Klasse den voll
	 * qualifizierten Namen dieser Klasse.
	 *
	 * @param filename Der Dateiname, z.B. <code>de/hshsoft/Testklasse.class</code>,
	 *                 nicht <code>null</code>.
	 * @return Der voll qualifizierte Klassenname, z.B. de.hshsoft.Testklasse, nicht
	 *         <code>null</code>.
	 * @since 1.0.0
	 */
	private static String getClassName(final String filename) {
		final String ret = filename.replaceAll("/", ".");
		// .class vom Namen abschneiden
		return ret.substring(0, ret.length() - 6);
	}
}
