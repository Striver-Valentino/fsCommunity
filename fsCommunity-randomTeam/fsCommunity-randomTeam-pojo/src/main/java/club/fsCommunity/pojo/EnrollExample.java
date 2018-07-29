package club.fsCommunity.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnrollExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEnrollIdIsNull() {
            addCriterion("enroll_id is null");
            return (Criteria) this;
        }

        public Criteria andEnrollIdIsNotNull() {
            addCriterion("enroll_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollIdEqualTo(String value) {
            addCriterion("enroll_id =", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotEqualTo(String value) {
            addCriterion("enroll_id <>", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdGreaterThan(String value) {
            addCriterion("enroll_id >", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdGreaterThanOrEqualTo(String value) {
            addCriterion("enroll_id >=", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLessThan(String value) {
            addCriterion("enroll_id <", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLessThanOrEqualTo(String value) {
            addCriterion("enroll_id <=", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLike(String value) {
            addCriterion("enroll_id like", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotLike(String value) {
            addCriterion("enroll_id not like", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdIn(List<String> values) {
            addCriterion("enroll_id in", values, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotIn(List<String> values) {
            addCriterion("enroll_id not in", values, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdBetween(String value1, String value2) {
            addCriterion("enroll_id between", value1, value2, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotBetween(String value1, String value2) {
            addCriterion("enroll_id not between", value1, value2, "enrollId");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("game_id like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("game_id not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("POSITION is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("POSITION =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("POSITION <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("POSITION >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("POSITION <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("POSITION <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("POSITION like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("POSITION not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("POSITION in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("POSITION not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("POSITION between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("POSITION not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(String value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(String value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(String value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(String value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(String value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(String value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLike(String value) {
            addCriterion("rating like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotLike(String value) {
            addCriterion("rating not like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<String> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<String> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(String value1, String value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(String value1, String value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNull() {
            addCriterion("enroll_date is null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNotNull() {
            addCriterion("enroll_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateEqualTo(Date value) {
            addCriterion("enroll_date =", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotEqualTo(Date value) {
            addCriterion("enroll_date <>", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThan(Date value) {
            addCriterion("enroll_date >", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThanOrEqualTo(Date value) {
            addCriterion("enroll_date >=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThan(Date value) {
            addCriterion("enroll_date <", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThanOrEqualTo(Date value) {
            addCriterion("enroll_date <=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIn(List<Date> values) {
            addCriterion("enroll_date in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotIn(List<Date> values) {
            addCriterion("enroll_date not in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateBetween(Date value1, Date value2) {
            addCriterion("enroll_date between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotBetween(Date value1, Date value2) {
            addCriterion("enroll_date not between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameIsNull() {
            addCriterion("signup_game_name is null");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameIsNotNull() {
            addCriterion("signup_game_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameEqualTo(String value) {
            addCriterion("signup_game_name =", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameNotEqualTo(String value) {
            addCriterion("signup_game_name <>", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameGreaterThan(String value) {
            addCriterion("signup_game_name >", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("signup_game_name >=", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameLessThan(String value) {
            addCriterion("signup_game_name <", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameLessThanOrEqualTo(String value) {
            addCriterion("signup_game_name <=", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameLike(String value) {
            addCriterion("signup_game_name like", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameNotLike(String value) {
            addCriterion("signup_game_name not like", value, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameIn(List<String> values) {
            addCriterion("signup_game_name in", values, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameNotIn(List<String> values) {
            addCriterion("signup_game_name not in", values, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameBetween(String value1, String value2) {
            addCriterion("signup_game_name between", value1, value2, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupGameNameNotBetween(String value1, String value2) {
            addCriterion("signup_game_name not between", value1, value2, "signupGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameIsNull() {
            addCriterion("signup_user_game_name is null");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameIsNotNull() {
            addCriterion("signup_user_game_name is not null");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameEqualTo(String value) {
            addCriterion("signup_user_game_name =", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameNotEqualTo(String value) {
            addCriterion("signup_user_game_name <>", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameGreaterThan(String value) {
            addCriterion("signup_user_game_name >", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("signup_user_game_name >=", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameLessThan(String value) {
            addCriterion("signup_user_game_name <", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameLessThanOrEqualTo(String value) {
            addCriterion("signup_user_game_name <=", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameLike(String value) {
            addCriterion("signup_user_game_name like", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameNotLike(String value) {
            addCriterion("signup_user_game_name not like", value, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameIn(List<String> values) {
            addCriterion("signup_user_game_name in", values, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameNotIn(List<String> values) {
            addCriterion("signup_user_game_name not in", values, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameBetween(String value1, String value2) {
            addCriterion("signup_user_game_name between", value1, value2, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andSignupUserGameNameNotBetween(String value1, String value2) {
            addCriterion("signup_user_game_name not between", value1, value2, "signupUserGameName");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreIsNull() {
            addCriterion("ability_score is null");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreIsNotNull() {
            addCriterion("ability_score is not null");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreEqualTo(Integer value) {
            addCriterion("ability_score =", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreNotEqualTo(Integer value) {
            addCriterion("ability_score <>", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreGreaterThan(Integer value) {
            addCriterion("ability_score >", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("ability_score >=", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreLessThan(Integer value) {
            addCriterion("ability_score <", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreLessThanOrEqualTo(Integer value) {
            addCriterion("ability_score <=", value, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreIn(List<Integer> values) {
            addCriterion("ability_score in", values, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreNotIn(List<Integer> values) {
            addCriterion("ability_score not in", values, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreBetween(Integer value1, Integer value2) {
            addCriterion("ability_score between", value1, value2, "abilityScore");
            return (Criteria) this;
        }

        public Criteria andAbilityScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("ability_score not between", value1, value2, "abilityScore");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}