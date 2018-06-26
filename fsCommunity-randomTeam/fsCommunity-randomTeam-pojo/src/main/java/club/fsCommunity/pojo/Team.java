package club.fsCommunity.pojo;

public class Team extends TeamKey {
    private String name;

    private String member1;

    private String member2;

    private String member3;

    private String lineup;

    private String opponent;

    private Integer vsresult;

    private Integer status;

    private String descr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1 == null ? null : member1.trim();
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2 == null ? null : member2.trim();
    }

    public String getMember3() {
        return member3;
    }

    public void setMember3(String member3) {
        this.member3 = member3 == null ? null : member3.trim();
    }

    public String getLineup() {
        return lineup;
    }

    public void setLineup(String lineup) {
        this.lineup = lineup == null ? null : lineup.trim();
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent == null ? null : opponent.trim();
    }

    public Integer getVsresult() {
        return vsresult;
    }

    public void setVsresult(Integer vsresult) {
        this.vsresult = vsresult;
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