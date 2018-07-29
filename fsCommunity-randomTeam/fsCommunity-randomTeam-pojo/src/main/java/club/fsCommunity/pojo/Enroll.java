package club.fsCommunity.pojo;

import java.util.Date;

public class Enroll extends EnrollKey {
    private String position;

    private String rating;

    private Integer status;

    private Date enrollDate;

    private String signupGameName;

    private String signupUserGameName;

    private Integer abilityScore;

    private String descr;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating == null ? null : rating.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getSignupGameName() {
        return signupGameName;
    }

    public void setSignupGameName(String signupGameName) {
        this.signupGameName = signupGameName == null ? null : signupGameName.trim();
    }

    public String getSignupUserGameName() {
        return signupUserGameName;
    }

    public void setSignupUserGameName(String signupUserGameName) {
        this.signupUserGameName = signupUserGameName == null ? null : signupUserGameName.trim();
    }

    public Integer getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(Integer abilityScore) {
        this.abilityScore = abilityScore;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}