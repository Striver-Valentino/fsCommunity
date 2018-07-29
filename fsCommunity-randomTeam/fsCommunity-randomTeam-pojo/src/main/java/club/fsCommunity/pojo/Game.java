package club.fsCommunity.pojo;

import java.util.Date;

public class Game {
    private String id;

    private String name;

    private Integer applyCount;

    private Integer status;

    private Date startDate;

    private Date endDate;

    private String launchUserId;

    private String sponsorName;

    private String undertakeName;

    private String supportName;

    private Date signUpLine;

    private Date launchDate;

    private String edge;

    private String launchUserName;

    private Integer groupStatus;

    private String descr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLaunchUserId() {
        return launchUserId;
    }

    public void setLaunchUserId(String launchUserId) {
        this.launchUserId = launchUserId == null ? null : launchUserId.trim();
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName == null ? null : sponsorName.trim();
    }

    public String getUndertakeName() {
        return undertakeName;
    }

    public void setUndertakeName(String undertakeName) {
        this.undertakeName = undertakeName == null ? null : undertakeName.trim();
    }

    public String getSupportName() {
        return supportName;
    }

    public void setSupportName(String supportName) {
        this.supportName = supportName == null ? null : supportName.trim();
    }

    public Date getSignUpLine() {
        return signUpLine;
    }

    public void setSignUpLine(Date signUpLine) {
        this.signUpLine = signUpLine;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge == null ? null : edge.trim();
    }

    public String getLaunchUserName() {
        return launchUserName;
    }

    public void setLaunchUserName(String launchUserName) {
        this.launchUserName = launchUserName == null ? null : launchUserName.trim();
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}