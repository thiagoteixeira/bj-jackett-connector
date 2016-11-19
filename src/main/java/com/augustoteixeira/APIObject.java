package com.augustoteixeira;

import java.util.ArrayList;
import java.util.List;

import com.augustoteixeira.configuration.ServerConfiguration;
import com.google.common.base.Joiner;

public class APIObject {
	private String t;
	private String cat;
	private String extended;
	private String apikey;
	private String offset;
	private String limit;

	// Initial: new attributes
	private String q;
	private String rid;
	private String season;
	private String ep;
	private String tvdbid;
	private String tvmazeid;
	private String imdbid;
	// End : new attributes

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getExtended() {
		return extended;
	}

	public void setExtended(String extended) {
		this.extended = extended;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getEp() {
		return ep;
	}

	public void setEp(String ep) {
		this.ep = ep;
	}

	public String getTvdbid() {
		return tvdbid;
	}

	public void setTvdbid(String tvdbid) {
		this.tvdbid = tvdbid;
	}

	public String getTvmazeid() {
		return tvmazeid;
	}

	public void setTvmazeid(String tvmazeid) {
		this.tvmazeid = tvmazeid;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	@Override
	public String toString() {
		return "APIObject [t=" + t + ", cat=" + cat + ", extended=" + extended + ", apikey=" + apikey + ", offset="
				+ offset + ", limit=" + limit + ", q=" + q + ", rid=" + rid + ", season=" + season + ", ep=" + ep
				+ ", tvdbid=" + tvdbid + ", tvmazeid=" + tvmazeid + ", imdbid=" + imdbid + "]";
	}

	public String createJackettURL(ServerConfiguration config) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://").append(config.getServer()).append(":").append(config.getPort());
		sb.append("/torznab/bjshare/api?");
		List<String> params = new ArrayList<>();
		if (t != null) {
			params.add("t=" + t);
		}
		if (cat != null) {
			params.add("cat=" + cat);
		}
		if (extended != null) {
			params.add("extended=" + extended);
		}
		if (apikey != null) {
			params.add("apikey=" + apikey);
		}
		if (offset != null) {
			params.add("offset=" + offset);
		}
		if (limit != null) {
			params.add("limit=" + limit);
		}
		if (q != null) {
			params.add("q=" + q);
		}
		if (rid != null) {
			params.add("rid=" + rid);
		}
		if (season != null) {
			params.add("season=" + season);
		}
		if (ep != null) {
			params.add("ep=" + ep);
		}
		if (tvdbid != null) {
			params.add("tvdbid=" + tvdbid);
		}
		if (tvmazeid != null) {
			params.add("tvmazeid=" + tvmazeid);
		}
		if (imdbid != null) {
			params.add("imdbid=" + imdbid);
		}
		String parameters = Joiner.on("&").join(params);
		sb.append(parameters);

		return sb.toString();
	}

}
