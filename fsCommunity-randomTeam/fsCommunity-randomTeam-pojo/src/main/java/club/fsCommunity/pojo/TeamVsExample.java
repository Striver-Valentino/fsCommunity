package club.fsCommunity.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeamVsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamVsExample() {
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

        public Criteria andTeamVsIdIsNull() {
            addCriterion("team_vs_Id is null");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdIsNotNull() {
            addCriterion("team_vs_Id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdEqualTo(String value) {
            addCriterion("team_vs_Id =", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdNotEqualTo(String value) {
            addCriterion("team_vs_Id <>", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdGreaterThan(String value) {
            addCriterion("team_vs_Id >", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_vs_Id >=", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdLessThan(String value) {
            addCriterion("team_vs_Id <", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdLessThanOrEqualTo(String value) {
            addCriterion("team_vs_Id <=", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdLike(String value) {
            addCriterion("team_vs_Id like", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdNotLike(String value) {
            addCriterion("team_vs_Id not like", value, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdIn(List<String> values) {
            addCriterion("team_vs_Id in", values, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdNotIn(List<String> values) {
            addCriterion("team_vs_Id not in", values, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdBetween(String value1, String value2) {
            addCriterion("team_vs_Id between", value1, value2, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeamVsIdNotBetween(String value1, String value2) {
            addCriterion("team_vs_Id not between", value1, value2, "teamVsId");
            return (Criteria) this;
        }

        public Criteria andTeam1IdIsNull() {
            addCriterion("team1_id is null");
            return (Criteria) this;
        }

        public Criteria andTeam1IdIsNotNull() {
            addCriterion("team1_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeam1IdEqualTo(String value) {
            addCriterion("team1_id =", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdNotEqualTo(String value) {
            addCriterion("team1_id <>", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdGreaterThan(String value) {
            addCriterion("team1_id >", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdGreaterThanOrEqualTo(String value) {
            addCriterion("team1_id >=", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdLessThan(String value) {
            addCriterion("team1_id <", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdLessThanOrEqualTo(String value) {
            addCriterion("team1_id <=", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdLike(String value) {
            addCriterion("team1_id like", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdNotLike(String value) {
            addCriterion("team1_id not like", value, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdIn(List<String> values) {
            addCriterion("team1_id in", values, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdNotIn(List<String> values) {
            addCriterion("team1_id not in", values, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdBetween(String value1, String value2) {
            addCriterion("team1_id between", value1, value2, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam1IdNotBetween(String value1, String value2) {
            addCriterion("team1_id not between", value1, value2, "team1Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdIsNull() {
            addCriterion("team2_id is null");
            return (Criteria) this;
        }

        public Criteria andTeam2IdIsNotNull() {
            addCriterion("team2_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeam2IdEqualTo(String value) {
            addCriterion("team2_id =", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdNotEqualTo(String value) {
            addCriterion("team2_id <>", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdGreaterThan(String value) {
            addCriterion("team2_id >", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdGreaterThanOrEqualTo(String value) {
            addCriterion("team2_id >=", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdLessThan(String value) {
            addCriterion("team2_id <", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdLessThanOrEqualTo(String value) {
            addCriterion("team2_id <=", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdLike(String value) {
            addCriterion("team2_id like", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdNotLike(String value) {
            addCriterion("team2_id not like", value, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdIn(List<String> values) {
            addCriterion("team2_id in", values, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdNotIn(List<String> values) {
            addCriterion("team2_id not in", values, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdBetween(String value1, String value2) {
            addCriterion("team2_id between", value1, value2, "team2Id");
            return (Criteria) this;
        }

        public Criteria andTeam2IdNotBetween(String value1, String value2) {
            addCriterion("team2_id not between", value1, value2, "team2Id");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andVsResultIsNull() {
            addCriterion("vs_result is null");
            return (Criteria) this;
        }

        public Criteria andVsResultIsNotNull() {
            addCriterion("vs_result is not null");
            return (Criteria) this;
        }

        public Criteria andVsResultEqualTo(String value) {
            addCriterion("vs_result =", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultNotEqualTo(String value) {
            addCriterion("vs_result <>", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultGreaterThan(String value) {
            addCriterion("vs_result >", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultGreaterThanOrEqualTo(String value) {
            addCriterion("vs_result >=", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultLessThan(String value) {
            addCriterion("vs_result <", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultLessThanOrEqualTo(String value) {
            addCriterion("vs_result <=", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultLike(String value) {
            addCriterion("vs_result like", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultNotLike(String value) {
            addCriterion("vs_result not like", value, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultIn(List<String> values) {
            addCriterion("vs_result in", values, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultNotIn(List<String> values) {
            addCriterion("vs_result not in", values, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultBetween(String value1, String value2) {
            addCriterion("vs_result between", value1, value2, "vsResult");
            return (Criteria) this;
        }

        public Criteria andVsResultNotBetween(String value1, String value2) {
            addCriterion("vs_result not between", value1, value2, "vsResult");
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

        public Criteria andTeam1NameIsNull() {
            addCriterion("team1_name is null");
            return (Criteria) this;
        }

        public Criteria andTeam1NameIsNotNull() {
            addCriterion("team1_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeam1NameEqualTo(String value) {
            addCriterion("team1_name =", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameNotEqualTo(String value) {
            addCriterion("team1_name <>", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameGreaterThan(String value) {
            addCriterion("team1_name >", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameGreaterThanOrEqualTo(String value) {
            addCriterion("team1_name >=", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameLessThan(String value) {
            addCriterion("team1_name <", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameLessThanOrEqualTo(String value) {
            addCriterion("team1_name <=", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameLike(String value) {
            addCriterion("team1_name like", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameNotLike(String value) {
            addCriterion("team1_name not like", value, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameIn(List<String> values) {
            addCriterion("team1_name in", values, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameNotIn(List<String> values) {
            addCriterion("team1_name not in", values, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameBetween(String value1, String value2) {
            addCriterion("team1_name between", value1, value2, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam1NameNotBetween(String value1, String value2) {
            addCriterion("team1_name not between", value1, value2, "team1Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameIsNull() {
            addCriterion("team2_name is null");
            return (Criteria) this;
        }

        public Criteria andTeam2NameIsNotNull() {
            addCriterion("team2_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeam2NameEqualTo(String value) {
            addCriterion("team2_name =", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameNotEqualTo(String value) {
            addCriterion("team2_name <>", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameGreaterThan(String value) {
            addCriterion("team2_name >", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameGreaterThanOrEqualTo(String value) {
            addCriterion("team2_name >=", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameLessThan(String value) {
            addCriterion("team2_name <", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameLessThanOrEqualTo(String value) {
            addCriterion("team2_name <=", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameLike(String value) {
            addCriterion("team2_name like", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameNotLike(String value) {
            addCriterion("team2_name not like", value, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameIn(List<String> values) {
            addCriterion("team2_name in", values, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameNotIn(List<String> values) {
            addCriterion("team2_name not in", values, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameBetween(String value1, String value2) {
            addCriterion("team2_name between", value1, value2, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam2NameNotBetween(String value1, String value2) {
            addCriterion("team2_name not between", value1, value2, "team2Name");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupIsNull() {
            addCriterion("team1_lineup is null");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupIsNotNull() {
            addCriterion("team1_lineup is not null");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupEqualTo(String value) {
            addCriterion("team1_lineup =", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupNotEqualTo(String value) {
            addCriterion("team1_lineup <>", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupGreaterThan(String value) {
            addCriterion("team1_lineup >", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupGreaterThanOrEqualTo(String value) {
            addCriterion("team1_lineup >=", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupLessThan(String value) {
            addCriterion("team1_lineup <", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupLessThanOrEqualTo(String value) {
            addCriterion("team1_lineup <=", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupLike(String value) {
            addCriterion("team1_lineup like", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupNotLike(String value) {
            addCriterion("team1_lineup not like", value, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupIn(List<String> values) {
            addCriterion("team1_lineup in", values, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupNotIn(List<String> values) {
            addCriterion("team1_lineup not in", values, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupBetween(String value1, String value2) {
            addCriterion("team1_lineup between", value1, value2, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam1LineupNotBetween(String value1, String value2) {
            addCriterion("team1_lineup not between", value1, value2, "team1Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupIsNull() {
            addCriterion("team2_lineup is null");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupIsNotNull() {
            addCriterion("team2_lineup is not null");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupEqualTo(String value) {
            addCriterion("team2_lineup =", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupNotEqualTo(String value) {
            addCriterion("team2_lineup <>", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupGreaterThan(String value) {
            addCriterion("team2_lineup >", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupGreaterThanOrEqualTo(String value) {
            addCriterion("team2_lineup >=", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupLessThan(String value) {
            addCriterion("team2_lineup <", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupLessThanOrEqualTo(String value) {
            addCriterion("team2_lineup <=", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupLike(String value) {
            addCriterion("team2_lineup like", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupNotLike(String value) {
            addCriterion("team2_lineup not like", value, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupIn(List<String> values) {
            addCriterion("team2_lineup in", values, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupNotIn(List<String> values) {
            addCriterion("team2_lineup not in", values, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupBetween(String value1, String value2) {
            addCriterion("team2_lineup between", value1, value2, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andTeam2LineupNotBetween(String value1, String value2) {
            addCriterion("team2_lineup not between", value1, value2, "team2Lineup");
            return (Criteria) this;
        }

        public Criteria andVsSignIsNull() {
            addCriterion("vs_sign is null");
            return (Criteria) this;
        }

        public Criteria andVsSignIsNotNull() {
            addCriterion("vs_sign is not null");
            return (Criteria) this;
        }

        public Criteria andVsSignEqualTo(String value) {
            addCriterion("vs_sign =", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignNotEqualTo(String value) {
            addCriterion("vs_sign <>", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignGreaterThan(String value) {
            addCriterion("vs_sign >", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignGreaterThanOrEqualTo(String value) {
            addCriterion("vs_sign >=", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignLessThan(String value) {
            addCriterion("vs_sign <", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignLessThanOrEqualTo(String value) {
            addCriterion("vs_sign <=", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignLike(String value) {
            addCriterion("vs_sign like", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignNotLike(String value) {
            addCriterion("vs_sign not like", value, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignIn(List<String> values) {
            addCriterion("vs_sign in", values, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignNotIn(List<String> values) {
            addCriterion("vs_sign not in", values, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignBetween(String value1, String value2) {
            addCriterion("vs_sign between", value1, value2, "vsSign");
            return (Criteria) this;
        }

        public Criteria andVsSignNotBetween(String value1, String value2) {
            addCriterion("vs_sign not between", value1, value2, "vsSign");
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