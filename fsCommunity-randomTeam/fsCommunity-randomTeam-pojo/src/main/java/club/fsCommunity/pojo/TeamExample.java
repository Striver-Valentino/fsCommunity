package club.fsCommunity.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamExample() {
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

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(String value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(String value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(String value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(String value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(String value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLike(String value) {
            addCriterion("team_id like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotLike(String value) {
            addCriterion("team_id not like", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<String> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<String> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(String value1, String value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(String value1, String value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
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

        public Criteria andMember1IsNull() {
            addCriterion("member1 is null");
            return (Criteria) this;
        }

        public Criteria andMember1IsNotNull() {
            addCriterion("member1 is not null");
            return (Criteria) this;
        }

        public Criteria andMember1EqualTo(String value) {
            addCriterion("member1 =", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1NotEqualTo(String value) {
            addCriterion("member1 <>", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1GreaterThan(String value) {
            addCriterion("member1 >", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1GreaterThanOrEqualTo(String value) {
            addCriterion("member1 >=", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1LessThan(String value) {
            addCriterion("member1 <", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1LessThanOrEqualTo(String value) {
            addCriterion("member1 <=", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1Like(String value) {
            addCriterion("member1 like", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1NotLike(String value) {
            addCriterion("member1 not like", value, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1In(List<String> values) {
            addCriterion("member1 in", values, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1NotIn(List<String> values) {
            addCriterion("member1 not in", values, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1Between(String value1, String value2) {
            addCriterion("member1 between", value1, value2, "member1");
            return (Criteria) this;
        }

        public Criteria andMember1NotBetween(String value1, String value2) {
            addCriterion("member1 not between", value1, value2, "member1");
            return (Criteria) this;
        }

        public Criteria andMember2IsNull() {
            addCriterion("member2 is null");
            return (Criteria) this;
        }

        public Criteria andMember2IsNotNull() {
            addCriterion("member2 is not null");
            return (Criteria) this;
        }

        public Criteria andMember2EqualTo(String value) {
            addCriterion("member2 =", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2NotEqualTo(String value) {
            addCriterion("member2 <>", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2GreaterThan(String value) {
            addCriterion("member2 >", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2GreaterThanOrEqualTo(String value) {
            addCriterion("member2 >=", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2LessThan(String value) {
            addCriterion("member2 <", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2LessThanOrEqualTo(String value) {
            addCriterion("member2 <=", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2Like(String value) {
            addCriterion("member2 like", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2NotLike(String value) {
            addCriterion("member2 not like", value, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2In(List<String> values) {
            addCriterion("member2 in", values, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2NotIn(List<String> values) {
            addCriterion("member2 not in", values, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2Between(String value1, String value2) {
            addCriterion("member2 between", value1, value2, "member2");
            return (Criteria) this;
        }

        public Criteria andMember2NotBetween(String value1, String value2) {
            addCriterion("member2 not between", value1, value2, "member2");
            return (Criteria) this;
        }

        public Criteria andMember3IsNull() {
            addCriterion("member3 is null");
            return (Criteria) this;
        }

        public Criteria andMember3IsNotNull() {
            addCriterion("member3 is not null");
            return (Criteria) this;
        }

        public Criteria andMember3EqualTo(String value) {
            addCriterion("member3 =", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3NotEqualTo(String value) {
            addCriterion("member3 <>", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3GreaterThan(String value) {
            addCriterion("member3 >", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3GreaterThanOrEqualTo(String value) {
            addCriterion("member3 >=", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3LessThan(String value) {
            addCriterion("member3 <", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3LessThanOrEqualTo(String value) {
            addCriterion("member3 <=", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3Like(String value) {
            addCriterion("member3 like", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3NotLike(String value) {
            addCriterion("member3 not like", value, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3In(List<String> values) {
            addCriterion("member3 in", values, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3NotIn(List<String> values) {
            addCriterion("member3 not in", values, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3Between(String value1, String value2) {
            addCriterion("member3 between", value1, value2, "member3");
            return (Criteria) this;
        }

        public Criteria andMember3NotBetween(String value1, String value2) {
            addCriterion("member3 not between", value1, value2, "member3");
            return (Criteria) this;
        }

        public Criteria andLineupIsNull() {
            addCriterion("lineup is null");
            return (Criteria) this;
        }

        public Criteria andLineupIsNotNull() {
            addCriterion("lineup is not null");
            return (Criteria) this;
        }

        public Criteria andLineupEqualTo(String value) {
            addCriterion("lineup =", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupNotEqualTo(String value) {
            addCriterion("lineup <>", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupGreaterThan(String value) {
            addCriterion("lineup >", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupGreaterThanOrEqualTo(String value) {
            addCriterion("lineup >=", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupLessThan(String value) {
            addCriterion("lineup <", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupLessThanOrEqualTo(String value) {
            addCriterion("lineup <=", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupLike(String value) {
            addCriterion("lineup like", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupNotLike(String value) {
            addCriterion("lineup not like", value, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupIn(List<String> values) {
            addCriterion("lineup in", values, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupNotIn(List<String> values) {
            addCriterion("lineup not in", values, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupBetween(String value1, String value2) {
            addCriterion("lineup between", value1, value2, "lineup");
            return (Criteria) this;
        }

        public Criteria andLineupNotBetween(String value1, String value2) {
            addCriterion("lineup not between", value1, value2, "lineup");
            return (Criteria) this;
        }

        public Criteria andOpponentIsNull() {
            addCriterion("opponent is null");
            return (Criteria) this;
        }

        public Criteria andOpponentIsNotNull() {
            addCriterion("opponent is not null");
            return (Criteria) this;
        }

        public Criteria andOpponentEqualTo(String value) {
            addCriterion("opponent =", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentNotEqualTo(String value) {
            addCriterion("opponent <>", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentGreaterThan(String value) {
            addCriterion("opponent >", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentGreaterThanOrEqualTo(String value) {
            addCriterion("opponent >=", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentLessThan(String value) {
            addCriterion("opponent <", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentLessThanOrEqualTo(String value) {
            addCriterion("opponent <=", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentLike(String value) {
            addCriterion("opponent like", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentNotLike(String value) {
            addCriterion("opponent not like", value, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentIn(List<String> values) {
            addCriterion("opponent in", values, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentNotIn(List<String> values) {
            addCriterion("opponent not in", values, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentBetween(String value1, String value2) {
            addCriterion("opponent between", value1, value2, "opponent");
            return (Criteria) this;
        }

        public Criteria andOpponentNotBetween(String value1, String value2) {
            addCriterion("opponent not between", value1, value2, "opponent");
            return (Criteria) this;
        }

        public Criteria andVsresultIsNull() {
            addCriterion("VSResult is null");
            return (Criteria) this;
        }

        public Criteria andVsresultIsNotNull() {
            addCriterion("VSResult is not null");
            return (Criteria) this;
        }

        public Criteria andVsresultEqualTo(Integer value) {
            addCriterion("VSResult =", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultNotEqualTo(Integer value) {
            addCriterion("VSResult <>", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultGreaterThan(Integer value) {
            addCriterion("VSResult >", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("VSResult >=", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultLessThan(Integer value) {
            addCriterion("VSResult <", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultLessThanOrEqualTo(Integer value) {
            addCriterion("VSResult <=", value, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultIn(List<Integer> values) {
            addCriterion("VSResult in", values, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultNotIn(List<Integer> values) {
            addCriterion("VSResult not in", values, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultBetween(Integer value1, Integer value2) {
            addCriterion("VSResult between", value1, value2, "vsresult");
            return (Criteria) this;
        }

        public Criteria andVsresultNotBetween(Integer value1, Integer value2) {
            addCriterion("VSResult not between", value1, value2, "vsresult");
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

        public Criteria andMember1GameNameIsNull() {
            addCriterion("member1_game_name is null");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameIsNotNull() {
            addCriterion("member1_game_name is not null");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameEqualTo(String value) {
            addCriterion("member1_game_name =", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameNotEqualTo(String value) {
            addCriterion("member1_game_name <>", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameGreaterThan(String value) {
            addCriterion("member1_game_name >", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameGreaterThanOrEqualTo(String value) {
            addCriterion("member1_game_name >=", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameLessThan(String value) {
            addCriterion("member1_game_name <", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameLessThanOrEqualTo(String value) {
            addCriterion("member1_game_name <=", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameLike(String value) {
            addCriterion("member1_game_name like", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameNotLike(String value) {
            addCriterion("member1_game_name not like", value, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameIn(List<String> values) {
            addCriterion("member1_game_name in", values, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameNotIn(List<String> values) {
            addCriterion("member1_game_name not in", values, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameBetween(String value1, String value2) {
            addCriterion("member1_game_name between", value1, value2, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember1GameNameNotBetween(String value1, String value2) {
            addCriterion("member1_game_name not between", value1, value2, "member1GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameIsNull() {
            addCriterion("member2_game_name is null");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameIsNotNull() {
            addCriterion("member2_game_name is not null");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameEqualTo(String value) {
            addCriterion("member2_game_name =", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameNotEqualTo(String value) {
            addCriterion("member2_game_name <>", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameGreaterThan(String value) {
            addCriterion("member2_game_name >", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameGreaterThanOrEqualTo(String value) {
            addCriterion("member2_game_name >=", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameLessThan(String value) {
            addCriterion("member2_game_name <", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameLessThanOrEqualTo(String value) {
            addCriterion("member2_game_name <=", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameLike(String value) {
            addCriterion("member2_game_name like", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameNotLike(String value) {
            addCriterion("member2_game_name not like", value, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameIn(List<String> values) {
            addCriterion("member2_game_name in", values, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameNotIn(List<String> values) {
            addCriterion("member2_game_name not in", values, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameBetween(String value1, String value2) {
            addCriterion("member2_game_name between", value1, value2, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember2GameNameNotBetween(String value1, String value2) {
            addCriterion("member2_game_name not between", value1, value2, "member2GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameIsNull() {
            addCriterion("member3_game_name is null");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameIsNotNull() {
            addCriterion("member3_game_name is not null");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameEqualTo(String value) {
            addCriterion("member3_game_name =", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameNotEqualTo(String value) {
            addCriterion("member3_game_name <>", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameGreaterThan(String value) {
            addCriterion("member3_game_name >", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameGreaterThanOrEqualTo(String value) {
            addCriterion("member3_game_name >=", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameLessThan(String value) {
            addCriterion("member3_game_name <", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameLessThanOrEqualTo(String value) {
            addCriterion("member3_game_name <=", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameLike(String value) {
            addCriterion("member3_game_name like", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameNotLike(String value) {
            addCriterion("member3_game_name not like", value, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameIn(List<String> values) {
            addCriterion("member3_game_name in", values, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameNotIn(List<String> values) {
            addCriterion("member3_game_name not in", values, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameBetween(String value1, String value2) {
            addCriterion("member3_game_name between", value1, value2, "member3GameName");
            return (Criteria) this;
        }

        public Criteria andMember3GameNameNotBetween(String value1, String value2) {
            addCriterion("member3_game_name not between", value1, value2, "member3GameName");
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