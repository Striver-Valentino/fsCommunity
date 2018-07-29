package club.fsCommunity.pojo;

public class TeamVsKey {
    private String teamVsId;

    private String team1Id;

    private String team2Id;

    private String gameId;

    public String getTeamVsId() {
        return teamVsId;
    }

    public void setTeamVsId(String teamVsId) {
        this.teamVsId = teamVsId == null ? null : teamVsId.trim();
    }

    public String getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(String team1Id) {
        this.team1Id = team1Id == null ? null : team1Id.trim();
    }

    public String getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(String team2Id) {
        this.team2Id = team2Id == null ? null : team2Id.trim();
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }
}