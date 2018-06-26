package club.fsCommunity.pojo;

public class Gameresult extends GameresultKey {
    private String champion;

    private String runnerUp;

    private String third;

    private Integer status;

    private String descr;

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion == null ? null : champion.trim();
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp == null ? null : runnerUp.trim();
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third == null ? null : third.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}