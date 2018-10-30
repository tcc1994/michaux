package com.tcc.main.domain.local.user;

import java.util.ArrayList;
import java.util.List;

public class UserSsoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSsoExample() {
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

        public Criteria andUsIdIsNull() {
            addCriterion("us_id is null");
            return (Criteria) this;
        }

        public Criteria andUsIdIsNotNull() {
            addCriterion("us_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdEqualTo(Long value) {
            addCriterion("us_id =", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotEqualTo(Long value) {
            addCriterion("us_id <>", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThan(Long value) {
            addCriterion("us_id >", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("us_id >=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThan(Long value) {
            addCriterion("us_id <", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThanOrEqualTo(Long value) {
            addCriterion("us_id <=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdIn(List<Long> values) {
            addCriterion("us_id in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotIn(List<Long> values) {
            addCriterion("us_id not in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdBetween(Long value1, Long value2) {
            addCriterion("us_id between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotBetween(Long value1, Long value2) {
            addCriterion("us_id not between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsPhoneIsNull() {
            addCriterion("us_phone is null");
            return (Criteria) this;
        }

        public Criteria andUsPhoneIsNotNull() {
            addCriterion("us_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUsPhoneEqualTo(Long value) {
            addCriterion("us_phone =", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneNotEqualTo(Long value) {
            addCriterion("us_phone <>", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneGreaterThan(Long value) {
            addCriterion("us_phone >", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneGreaterThanOrEqualTo(Long value) {
            addCriterion("us_phone >=", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneLessThan(Long value) {
            addCriterion("us_phone <", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneLessThanOrEqualTo(Long value) {
            addCriterion("us_phone <=", value, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneIn(List<Long> values) {
            addCriterion("us_phone in", values, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneNotIn(List<Long> values) {
            addCriterion("us_phone not in", values, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneBetween(Long value1, Long value2) {
            addCriterion("us_phone between", value1, value2, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsPhoneNotBetween(Long value1, Long value2) {
            addCriterion("us_phone not between", value1, value2, "usPhone");
            return (Criteria) this;
        }

        public Criteria andUsAccountIsNull() {
            addCriterion("us_account is null");
            return (Criteria) this;
        }

        public Criteria andUsAccountIsNotNull() {
            addCriterion("us_account is not null");
            return (Criteria) this;
        }

        public Criteria andUsAccountEqualTo(String value) {
            addCriterion("us_account =", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountNotEqualTo(String value) {
            addCriterion("us_account <>", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountGreaterThan(String value) {
            addCriterion("us_account >", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountGreaterThanOrEqualTo(String value) {
            addCriterion("us_account >=", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountLessThan(String value) {
            addCriterion("us_account <", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountLessThanOrEqualTo(String value) {
            addCriterion("us_account <=", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountLike(String value) {
            addCriterion("us_account like", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountNotLike(String value) {
            addCriterion("us_account not like", value, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountIn(List<String> values) {
            addCriterion("us_account in", values, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountNotIn(List<String> values) {
            addCriterion("us_account not in", values, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountBetween(String value1, String value2) {
            addCriterion("us_account between", value1, value2, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsAccountNotBetween(String value1, String value2) {
            addCriterion("us_account not between", value1, value2, "usAccount");
            return (Criteria) this;
        }

        public Criteria andUsPasswdIsNull() {
            addCriterion("us_passwd is null");
            return (Criteria) this;
        }

        public Criteria andUsPasswdIsNotNull() {
            addCriterion("us_passwd is not null");
            return (Criteria) this;
        }

        public Criteria andUsPasswdEqualTo(String value) {
            addCriterion("us_passwd =", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdNotEqualTo(String value) {
            addCriterion("us_passwd <>", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdGreaterThan(String value) {
            addCriterion("us_passwd >", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("us_passwd >=", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdLessThan(String value) {
            addCriterion("us_passwd <", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdLessThanOrEqualTo(String value) {
            addCriterion("us_passwd <=", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdLike(String value) {
            addCriterion("us_passwd like", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdNotLike(String value) {
            addCriterion("us_passwd not like", value, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdIn(List<String> values) {
            addCriterion("us_passwd in", values, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdNotIn(List<String> values) {
            addCriterion("us_passwd not in", values, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdBetween(String value1, String value2) {
            addCriterion("us_passwd between", value1, value2, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsPasswdNotBetween(String value1, String value2) {
            addCriterion("us_passwd not between", value1, value2, "usPasswd");
            return (Criteria) this;
        }

        public Criteria andUsSecretIsNull() {
            addCriterion("us_secret is null");
            return (Criteria) this;
        }

        public Criteria andUsSecretIsNotNull() {
            addCriterion("us_secret is not null");
            return (Criteria) this;
        }

        public Criteria andUsSecretEqualTo(String value) {
            addCriterion("us_secret =", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretNotEqualTo(String value) {
            addCriterion("us_secret <>", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretGreaterThan(String value) {
            addCriterion("us_secret >", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretGreaterThanOrEqualTo(String value) {
            addCriterion("us_secret >=", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretLessThan(String value) {
            addCriterion("us_secret <", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretLessThanOrEqualTo(String value) {
            addCriterion("us_secret <=", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretLike(String value) {
            addCriterion("us_secret like", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretNotLike(String value) {
            addCriterion("us_secret not like", value, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretIn(List<String> values) {
            addCriterion("us_secret in", values, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretNotIn(List<String> values) {
            addCriterion("us_secret not in", values, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretBetween(String value1, String value2) {
            addCriterion("us_secret between", value1, value2, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsSecretNotBetween(String value1, String value2) {
            addCriterion("us_secret not between", value1, value2, "usSecret");
            return (Criteria) this;
        }

        public Criteria andUsRegClientIsNull() {
            addCriterion("us_reg_client is null");
            return (Criteria) this;
        }

        public Criteria andUsRegClientIsNotNull() {
            addCriterion("us_reg_client is not null");
            return (Criteria) this;
        }

        public Criteria andUsRegClientEqualTo(Integer value) {
            addCriterion("us_reg_client =", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientNotEqualTo(Integer value) {
            addCriterion("us_reg_client <>", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientGreaterThan(Integer value) {
            addCriterion("us_reg_client >", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_reg_client >=", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientLessThan(Integer value) {
            addCriterion("us_reg_client <", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientLessThanOrEqualTo(Integer value) {
            addCriterion("us_reg_client <=", value, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientIn(List<Integer> values) {
            addCriterion("us_reg_client in", values, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientNotIn(List<Integer> values) {
            addCriterion("us_reg_client not in", values, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientBetween(Integer value1, Integer value2) {
            addCriterion("us_reg_client between", value1, value2, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsRegClientNotBetween(Integer value1, Integer value2) {
            addCriterion("us_reg_client not between", value1, value2, "usRegClient");
            return (Criteria) this;
        }

        public Criteria andUsFrozenIsNull() {
            addCriterion("us_frozen is null");
            return (Criteria) this;
        }

        public Criteria andUsFrozenIsNotNull() {
            addCriterion("us_frozen is not null");
            return (Criteria) this;
        }

        public Criteria andUsFrozenEqualTo(Integer value) {
            addCriterion("us_frozen =", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenNotEqualTo(Integer value) {
            addCriterion("us_frozen <>", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenGreaterThan(Integer value) {
            addCriterion("us_frozen >", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_frozen >=", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenLessThan(Integer value) {
            addCriterion("us_frozen <", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenLessThanOrEqualTo(Integer value) {
            addCriterion("us_frozen <=", value, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenIn(List<Integer> values) {
            addCriterion("us_frozen in", values, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenNotIn(List<Integer> values) {
            addCriterion("us_frozen not in", values, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenBetween(Integer value1, Integer value2) {
            addCriterion("us_frozen between", value1, value2, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsFrozenNotBetween(Integer value1, Integer value2) {
            addCriterion("us_frozen not between", value1, value2, "usFrozen");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateIsNull() {
            addCriterion("us_time_create is null");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateIsNotNull() {
            addCriterion("us_time_create is not null");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateEqualTo(String value) {
            addCriterion("us_time_create =", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateNotEqualTo(String value) {
            addCriterion("us_time_create <>", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateGreaterThan(String value) {
            addCriterion("us_time_create >", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateGreaterThanOrEqualTo(String value) {
            addCriterion("us_time_create >=", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateLessThan(String value) {
            addCriterion("us_time_create <", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateLessThanOrEqualTo(String value) {
            addCriterion("us_time_create <=", value, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateIn(List<String> values) {
            addCriterion("us_time_create in", values, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateNotIn(List<String> values) {
            addCriterion("us_time_create not in", values, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateBetween(String value1, String value2) {
            addCriterion("us_time_create between", value1, value2, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeCreateNotBetween(String value1, String value2) {
            addCriterion("us_time_create not between", value1, value2, "usTimeCreate");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyIsNull() {
            addCriterion("us_time_modify is null");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyIsNotNull() {
            addCriterion("us_time_modify is not null");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyEqualTo(String value) {
            addCriterion("us_time_modify =", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyNotEqualTo(String value) {
            addCriterion("us_time_modify <>", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyGreaterThan(String value) {
            addCriterion("us_time_modify >", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyGreaterThanOrEqualTo(String value) {
            addCriterion("us_time_modify >=", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyLessThan(String value) {
            addCriterion("us_time_modify <", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyLessThanOrEqualTo(String value) {
            addCriterion("us_time_modify <=", value, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyIn(List<String> values) {
            addCriterion("us_time_modify in", values, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyNotIn(List<String> values) {
            addCriterion("us_time_modify not in", values, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyBetween(String value1, String value2) {
            addCriterion("us_time_modify between", value1, value2, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsTimeModifyNotBetween(String value1, String value2) {
            addCriterion("us_time_modify not between", value1, value2, "usTimeModify");
            return (Criteria) this;
        }

        public Criteria andUsYnIsNull() {
            addCriterion("us_yn is null");
            return (Criteria) this;
        }

        public Criteria andUsYnIsNotNull() {
            addCriterion("us_yn is not null");
            return (Criteria) this;
        }

        public Criteria andUsYnEqualTo(Integer value) {
            addCriterion("us_yn =", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnNotEqualTo(Integer value) {
            addCriterion("us_yn <>", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnGreaterThan(Integer value) {
            addCriterion("us_yn >", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_yn >=", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnLessThan(Integer value) {
            addCriterion("us_yn <", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnLessThanOrEqualTo(Integer value) {
            addCriterion("us_yn <=", value, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnIn(List<Integer> values) {
            addCriterion("us_yn in", values, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnNotIn(List<Integer> values) {
            addCriterion("us_yn not in", values, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnBetween(Integer value1, Integer value2) {
            addCriterion("us_yn between", value1, value2, "usYn");
            return (Criteria) this;
        }

        public Criteria andUsYnNotBetween(Integer value1, Integer value2) {
            addCriterion("us_yn not between", value1, value2, "usYn");
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