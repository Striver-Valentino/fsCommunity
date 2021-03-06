package club.fsCommunity.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNull() {
            addCriterion("apply_count is null");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNotNull() {
            addCriterion("apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCountEqualTo(Integer value) {
            addCriterion("apply_count =", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotEqualTo(Integer value) {
            addCriterion("apply_count <>", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThan(Integer value) {
            addCriterion("apply_count >", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_count >=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThan(Integer value) {
            addCriterion("apply_count <", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_count <=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountIn(List<Integer> values) {
            addCriterion("apply_count in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotIn(List<Integer> values) {
            addCriterion("apply_count not in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("apply_count between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_count not between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIsNull() {
            addCriterion("launch_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIsNotNull() {
            addCriterion("launch_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdEqualTo(String value) {
            addCriterion("launch_user_id =", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotEqualTo(String value) {
            addCriterion("launch_user_id <>", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdGreaterThan(String value) {
            addCriterion("launch_user_id >", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("launch_user_id >=", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdLessThan(String value) {
            addCriterion("launch_user_id <", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdLessThanOrEqualTo(String value) {
            addCriterion("launch_user_id <=", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdLike(String value) {
            addCriterion("launch_user_id like", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotLike(String value) {
            addCriterion("launch_user_id not like", value, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdIn(List<String> values) {
            addCriterion("launch_user_id in", values, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotIn(List<String> values) {
            addCriterion("launch_user_id not in", values, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdBetween(String value1, String value2) {
            addCriterion("launch_user_id between", value1, value2, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andLaunchUserIdNotBetween(String value1, String value2) {
            addCriterion("launch_user_id not between", value1, value2, "launchUserId");
            return (Criteria) this;
        }

        public Criteria andSponsorNameIsNull() {
            addCriterion("sponsor_name is null");
            return (Criteria) this;
        }

        public Criteria andSponsorNameIsNotNull() {
            addCriterion("sponsor_name is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorNameEqualTo(String value) {
            addCriterion("sponsor_name =", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameNotEqualTo(String value) {
            addCriterion("sponsor_name <>", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameGreaterThan(String value) {
            addCriterion("sponsor_name >", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameGreaterThanOrEqualTo(String value) {
            addCriterion("sponsor_name >=", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameLessThan(String value) {
            addCriterion("sponsor_name <", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameLessThanOrEqualTo(String value) {
            addCriterion("sponsor_name <=", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameLike(String value) {
            addCriterion("sponsor_name like", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameNotLike(String value) {
            addCriterion("sponsor_name not like", value, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameIn(List<String> values) {
            addCriterion("sponsor_name in", values, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameNotIn(List<String> values) {
            addCriterion("sponsor_name not in", values, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameBetween(String value1, String value2) {
            addCriterion("sponsor_name between", value1, value2, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andSponsorNameNotBetween(String value1, String value2) {
            addCriterion("sponsor_name not between", value1, value2, "sponsorName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameIsNull() {
            addCriterion("undertake_name is null");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameIsNotNull() {
            addCriterion("undertake_name is not null");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameEqualTo(String value) {
            addCriterion("undertake_name =", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameNotEqualTo(String value) {
            addCriterion("undertake_name <>", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameGreaterThan(String value) {
            addCriterion("undertake_name >", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameGreaterThanOrEqualTo(String value) {
            addCriterion("undertake_name >=", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameLessThan(String value) {
            addCriterion("undertake_name <", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameLessThanOrEqualTo(String value) {
            addCriterion("undertake_name <=", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameLike(String value) {
            addCriterion("undertake_name like", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameNotLike(String value) {
            addCriterion("undertake_name not like", value, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameIn(List<String> values) {
            addCriterion("undertake_name in", values, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameNotIn(List<String> values) {
            addCriterion("undertake_name not in", values, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameBetween(String value1, String value2) {
            addCriterion("undertake_name between", value1, value2, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andUndertakeNameNotBetween(String value1, String value2) {
            addCriterion("undertake_name not between", value1, value2, "undertakeName");
            return (Criteria) this;
        }

        public Criteria andSupportNameIsNull() {
            addCriterion("support_name is null");
            return (Criteria) this;
        }

        public Criteria andSupportNameIsNotNull() {
            addCriterion("support_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupportNameEqualTo(String value) {
            addCriterion("support_name =", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameNotEqualTo(String value) {
            addCriterion("support_name <>", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameGreaterThan(String value) {
            addCriterion("support_name >", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameGreaterThanOrEqualTo(String value) {
            addCriterion("support_name >=", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameLessThan(String value) {
            addCriterion("support_name <", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameLessThanOrEqualTo(String value) {
            addCriterion("support_name <=", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameLike(String value) {
            addCriterion("support_name like", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameNotLike(String value) {
            addCriterion("support_name not like", value, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameIn(List<String> values) {
            addCriterion("support_name in", values, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameNotIn(List<String> values) {
            addCriterion("support_name not in", values, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameBetween(String value1, String value2) {
            addCriterion("support_name between", value1, value2, "supportName");
            return (Criteria) this;
        }

        public Criteria andSupportNameNotBetween(String value1, String value2) {
            addCriterion("support_name not between", value1, value2, "supportName");
            return (Criteria) this;
        }

        public Criteria andSignUpLineIsNull() {
            addCriterion("sign_up_line is null");
            return (Criteria) this;
        }

        public Criteria andSignUpLineIsNotNull() {
            addCriterion("sign_up_line is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpLineEqualTo(Date value) {
            addCriterion("sign_up_line =", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineNotEqualTo(Date value) {
            addCriterion("sign_up_line <>", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineGreaterThan(Date value) {
            addCriterion("sign_up_line >", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_up_line >=", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineLessThan(Date value) {
            addCriterion("sign_up_line <", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineLessThanOrEqualTo(Date value) {
            addCriterion("sign_up_line <=", value, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineIn(List<Date> values) {
            addCriterion("sign_up_line in", values, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineNotIn(List<Date> values) {
            addCriterion("sign_up_line not in", values, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineBetween(Date value1, Date value2) {
            addCriterion("sign_up_line between", value1, value2, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andSignUpLineNotBetween(Date value1, Date value2) {
            addCriterion("sign_up_line not between", value1, value2, "signUpLine");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIsNull() {
            addCriterion("launch_date is null");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIsNotNull() {
            addCriterion("launch_date is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchDateEqualTo(Date value) {
            addCriterion("launch_date =", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotEqualTo(Date value) {
            addCriterion("launch_date <>", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateGreaterThan(Date value) {
            addCriterion("launch_date >", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateGreaterThanOrEqualTo(Date value) {
            addCriterion("launch_date >=", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateLessThan(Date value) {
            addCriterion("launch_date <", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateLessThanOrEqualTo(Date value) {
            addCriterion("launch_date <=", value, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateIn(List<Date> values) {
            addCriterion("launch_date in", values, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotIn(List<Date> values) {
            addCriterion("launch_date not in", values, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateBetween(Date value1, Date value2) {
            addCriterion("launch_date between", value1, value2, "launchDate");
            return (Criteria) this;
        }

        public Criteria andLaunchDateNotBetween(Date value1, Date value2) {
            addCriterion("launch_date not between", value1, value2, "launchDate");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNull() {
            addCriterion("edge is null");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNotNull() {
            addCriterion("edge is not null");
            return (Criteria) this;
        }

        public Criteria andEdgeEqualTo(String value) {
            addCriterion("edge =", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotEqualTo(String value) {
            addCriterion("edge <>", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThan(String value) {
            addCriterion("edge >", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThanOrEqualTo(String value) {
            addCriterion("edge >=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThan(String value) {
            addCriterion("edge <", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThanOrEqualTo(String value) {
            addCriterion("edge <=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLike(String value) {
            addCriterion("edge like", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotLike(String value) {
            addCriterion("edge not like", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeIn(List<String> values) {
            addCriterion("edge in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotIn(List<String> values) {
            addCriterion("edge not in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeBetween(String value1, String value2) {
            addCriterion("edge between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotBetween(String value1, String value2) {
            addCriterion("edge not between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIsNull() {
            addCriterion("launch_user_name is null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIsNotNull() {
            addCriterion("launch_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameEqualTo(String value) {
            addCriterion("launch_user_name =", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotEqualTo(String value) {
            addCriterion("launch_user_name <>", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameGreaterThan(String value) {
            addCriterion("launch_user_name >", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("launch_user_name >=", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLessThan(String value) {
            addCriterion("launch_user_name <", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLessThanOrEqualTo(String value) {
            addCriterion("launch_user_name <=", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameLike(String value) {
            addCriterion("launch_user_name like", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotLike(String value) {
            addCriterion("launch_user_name not like", value, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameIn(List<String> values) {
            addCriterion("launch_user_name in", values, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotIn(List<String> values) {
            addCriterion("launch_user_name not in", values, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameBetween(String value1, String value2) {
            addCriterion("launch_user_name between", value1, value2, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andLaunchUserNameNotBetween(String value1, String value2) {
            addCriterion("launch_user_name not between", value1, value2, "launchUserName");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNull() {
            addCriterion("group_status is null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNotNull() {
            addCriterion("group_status is not null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusEqualTo(Integer value) {
            addCriterion("group_status =", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotEqualTo(Integer value) {
            addCriterion("group_status <>", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThan(Integer value) {
            addCriterion("group_status >", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_status >=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThan(Integer value) {
            addCriterion("group_status <", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThanOrEqualTo(Integer value) {
            addCriterion("group_status <=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIn(List<Integer> values) {
            addCriterion("group_status in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotIn(List<Integer> values) {
            addCriterion("group_status not in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusBetween(Integer value1, Integer value2) {
            addCriterion("group_status between", value1, value2, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("group_status not between", value1, value2, "groupStatus");
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