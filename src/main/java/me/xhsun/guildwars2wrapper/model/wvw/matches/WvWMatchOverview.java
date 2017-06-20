package me.xhsun.guildwars2wrapper.model.wvw.matches;

import java.util.List;

/**
 * For more info on WvW matches API go <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">here</a><br/>
 * Model class for WvW match overview
 *
 * @author xhsun
 * @since 2017-06-19
 */
public class WvWMatchOverview extends WvWMatch {
	private String start_time, end_time;
	private WvWMatchDetail.Score worlds;
	private AllWorld all_worlds;

	public String getStart_time() {
		return start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public WvWMatchDetail.Score getWorlds() {
		return worlds;
	}

	public AllWorld getAll_worlds() {
		return all_worlds;
	}

	@Override
	public String toString() {
		return "WvWMatchOverview{" +
				"id=" + getId() +
				", start_time='" + start_time + '\'' +
				", end_time='" + end_time + '\'' +
				", worlds=" + worlds +
				", all_worlds=" + all_worlds +
				'}';
	}

	public class AllWorld {
		private List<Integer> red, blue, green;

		public List<Integer> getRed() {
			return red;
		}

		public List<Integer> getBlue() {
			return blue;
		}

		public List<Integer> getGreen() {
			return green;
		}

		@Override
		public String toString() {
			return "AllWorld{" +
					"red=" + red +
					", blue=" + blue +
					", green=" + green +
					'}';
		}
	}
}
