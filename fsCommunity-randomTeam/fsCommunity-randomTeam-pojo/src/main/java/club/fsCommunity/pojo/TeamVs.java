package club.fsCommunity.pojo;

public class TeamVs extends TeamVsKey {
    private String name;

    private String vsResult;

    private Integer status;

    private String team1Name;

    private String team2Name;

    private String team1Lineup;

    private String team2Lineup;

    private String vsSign;

    private String descr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVsResult() {
        return vsResult;
    }

    public void setVsResult(String vsResult) {
        this.vsResult = vsResult == null ? null : vsResult.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name == null ? null : team1Name.trim();
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name == null ? null : team2Name.trim();
    }

    public String getTeam1Lineup() {
        return team1Lineup;
    }

    public void setTeam1Lineup(String team1Lineup) {
        this.team1Lineup = team1Lineup == null ? null : team1Lineup.trim();
    }

    public String getTeam2Lineup() {
        return team2Lineup;
    }

    public void setTeam2Lineup(String team2Lineup) {
        this.team2Lineup = team2Lineup == null ? null : team2Lineup.trim();
    }

    public String getVsSign() {
        return vsSign;
    }

    public void setVsSign(String vsSign) {
        this.vsSign = vsSign == null ? null : vsSign.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}