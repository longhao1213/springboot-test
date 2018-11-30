package com.lh.model;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Integer value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIsNull() {
            addCriterion("r_description is null");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIsNotNull() {
            addCriterion("r_description is not null");
            return (Criteria) this;
        }

        public Criteria andRDescriptionEqualTo(String value) {
            addCriterion("r_description =", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotEqualTo(String value) {
            addCriterion("r_description <>", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionGreaterThan(String value) {
            addCriterion("r_description >", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("r_description >=", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLessThan(String value) {
            addCriterion("r_description <", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLessThanOrEqualTo(String value) {
            addCriterion("r_description <=", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLike(String value) {
            addCriterion("r_description like", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotLike(String value) {
            addCriterion("r_description not like", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIn(List<String> values) {
            addCriterion("r_description in", values, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotIn(List<String> values) {
            addCriterion("r_description not in", values, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionBetween(String value1, String value2) {
            addCriterion("r_description between", value1, value2, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotBetween(String value1, String value2) {
            addCriterion("r_description not between", value1, value2, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRKeywordIsNull() {
            addCriterion("r_keyword is null");
            return (Criteria) this;
        }

        public Criteria andRKeywordIsNotNull() {
            addCriterion("r_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andRKeywordEqualTo(String value) {
            addCriterion("r_keyword =", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordNotEqualTo(String value) {
            addCriterion("r_keyword <>", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordGreaterThan(String value) {
            addCriterion("r_keyword >", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("r_keyword >=", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordLessThan(String value) {
            addCriterion("r_keyword <", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordLessThanOrEqualTo(String value) {
            addCriterion("r_keyword <=", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordLike(String value) {
            addCriterion("r_keyword like", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordNotLike(String value) {
            addCriterion("r_keyword not like", value, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordIn(List<String> values) {
            addCriterion("r_keyword in", values, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordNotIn(List<String> values) {
            addCriterion("r_keyword not in", values, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordBetween(String value1, String value2) {
            addCriterion("r_keyword between", value1, value2, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRKeywordNotBetween(String value1, String value2) {
            addCriterion("r_keyword not between", value1, value2, "rKeyword");
            return (Criteria) this;
        }

        public Criteria andRNameIsNull() {
            addCriterion("r_name is null");
            return (Criteria) this;
        }

        public Criteria andRNameIsNotNull() {
            addCriterion("r_name is not null");
            return (Criteria) this;
        }

        public Criteria andRNameEqualTo(String value) {
            addCriterion("r_name =", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotEqualTo(String value) {
            addCriterion("r_name <>", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThan(String value) {
            addCriterion("r_name >", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_name >=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThan(String value) {
            addCriterion("r_name <", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThanOrEqualTo(String value) {
            addCriterion("r_name <=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLike(String value) {
            addCriterion("r_name like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotLike(String value) {
            addCriterion("r_name not like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameIn(List<String> values) {
            addCriterion("r_name in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotIn(List<String> values) {
            addCriterion("r_name not in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameBetween(String value1, String value2) {
            addCriterion("r_name between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotBetween(String value1, String value2) {
            addCriterion("r_name not between", value1, value2, "rName");
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