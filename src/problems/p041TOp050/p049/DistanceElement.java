package problems.p041TOp050.p049;

public class DistanceElement {

	private Integer from;
	private Integer too;
	private Integer distance;

	public DistanceElement(Integer from, Integer too, Integer distance) {
		this.from = from;
		this.too = too;
		this.distance = distance;

		if (this.distance < 0) {
			this.distance = this.distance * -1;
		}

		if (this.from > this.too) {
			this.from = too;
			this.too = from;
		}
	}

	public Integer getFrom() {
		return from;
	}

	public Integer getToo() {
		return too;
	}

	public Integer getDistance() {
		return distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((too == null) ? 0 : too.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistanceElement other = (DistanceElement) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (too == null) {
			if (other.too != null)
				return false;
		} else if (!too.equals(other.too))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DistanceElement [from=" + from + ", too=" + too + ", distance=" + distance + "]";
	}

}
