package com.tcc.main.domain.local.profile;

import java.util.ArrayList;
import java.util.List;

public class RoleProfileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleProfileExample() {
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

        public Criteria andRpIdIsNull() {
            addCriterion("rp_id is null");
            return (Criteria) this;
        }

        public Criteria andRpIdIsNotNull() {
            addCriterion("rp_id is not null");
            return (Criteria) this;
        }

        public Criteria andRpIdEqualTo(Long value) {
            addCriterion("rp_id =", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotEqualTo(Long value) {
            addCriterion("rp_id <>", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdGreaterThan(Long value) {
            addCriterion("rp_id >", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rp_id >=", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdLessThan(Long value) {
            addCriterion("rp_id <", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdLessThanOrEqualTo(Long value) {
            addCriterion("rp_id <=", value, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdIn(List<Long> values) {
            addCriterion("rp_id in", values, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotIn(List<Long> values) {
            addCriterion("rp_id not in", values, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdBetween(Long value1, Long value2) {
            addCriterion("rp_id between", value1, value2, "rpId");
            return (Criteria) this;
        }

        public Criteria andRpIdNotBetween(Long value1, Long value2) {
            addCriterion("rp_id not between", value1, value2, "rpId");
            return (Criteria) this;
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

        public Criteria andRpHeaderIsNull() {
            addCriterion("rp_header is null");
            return (Criteria) this;
        }

        public Criteria andRpHeaderIsNotNull() {
            addCriterion("rp_header is not null");
            return (Criteria) this;
        }

        public Criteria andRpHeaderEqualTo(String value) {
            addCriterion("rp_header =", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderNotEqualTo(String value) {
            addCriterion("rp_header <>", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderGreaterThan(String value) {
            addCriterion("rp_header >", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("rp_header >=", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderLessThan(String value) {
            addCriterion("rp_header <", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderLessThanOrEqualTo(String value) {
            addCriterion("rp_header <=", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderLike(String value) {
            addCriterion("rp_header like", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderNotLike(String value) {
            addCriterion("rp_header not like", value, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderIn(List<String> values) {
            addCriterion("rp_header in", values, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderNotIn(List<String> values) {
            addCriterion("rp_header not in", values, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderBetween(String value1, String value2) {
            addCriterion("rp_header between", value1, value2, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpHeaderNotBetween(String value1, String value2) {
            addCriterion("rp_header not between", value1, value2, "rpHeader");
            return (Criteria) this;
        }

        public Criteria andRpSexIsNull() {
            addCriterion("rp_sex is null");
            return (Criteria) this;
        }

        public Criteria andRpSexIsNotNull() {
            addCriterion("rp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andRpSexEqualTo(Integer value) {
            addCriterion("rp_sex =", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexNotEqualTo(Integer value) {
            addCriterion("rp_sex <>", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexGreaterThan(Integer value) {
            addCriterion("rp_sex >", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("rp_sex >=", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexLessThan(Integer value) {
            addCriterion("rp_sex <", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexLessThanOrEqualTo(Integer value) {
            addCriterion("rp_sex <=", value, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexIn(List<Integer> values) {
            addCriterion("rp_sex in", values, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexNotIn(List<Integer> values) {
            addCriterion("rp_sex not in", values, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexBetween(Integer value1, Integer value2) {
            addCriterion("rp_sex between", value1, value2, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpSexNotBetween(Integer value1, Integer value2) {
            addCriterion("rp_sex not between", value1, value2, "rpSex");
            return (Criteria) this;
        }

        public Criteria andRpNickNameIsNull() {
            addCriterion("rp_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andRpNickNameIsNotNull() {
            addCriterion("rp_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andRpNickNameEqualTo(String value) {
            addCriterion("rp_nick_name =", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameNotEqualTo(String value) {
            addCriterion("rp_nick_name <>", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameGreaterThan(String value) {
            addCriterion("rp_nick_name >", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("rp_nick_name >=", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameLessThan(String value) {
            addCriterion("rp_nick_name <", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameLessThanOrEqualTo(String value) {
            addCriterion("rp_nick_name <=", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameLike(String value) {
            addCriterion("rp_nick_name like", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameNotLike(String value) {
            addCriterion("rp_nick_name not like", value, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameIn(List<String> values) {
            addCriterion("rp_nick_name in", values, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameNotIn(List<String> values) {
            addCriterion("rp_nick_name not in", values, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameBetween(String value1, String value2) {
            addCriterion("rp_nick_name between", value1, value2, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpNickNameNotBetween(String value1, String value2) {
            addCriterion("rp_nick_name not between", value1, value2, "rpNickName");
            return (Criteria) this;
        }

        public Criteria andRpEmailIsNull() {
            addCriterion("rp_email is null");
            return (Criteria) this;
        }

        public Criteria andRpEmailIsNotNull() {
            addCriterion("rp_email is not null");
            return (Criteria) this;
        }

        public Criteria andRpEmailEqualTo(String value) {
            addCriterion("rp_email =", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailNotEqualTo(String value) {
            addCriterion("rp_email <>", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailGreaterThan(String value) {
            addCriterion("rp_email >", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailGreaterThanOrEqualTo(String value) {
            addCriterion("rp_email >=", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailLessThan(String value) {
            addCriterion("rp_email <", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailLessThanOrEqualTo(String value) {
            addCriterion("rp_email <=", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailLike(String value) {
            addCriterion("rp_email like", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailNotLike(String value) {
            addCriterion("rp_email not like", value, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailIn(List<String> values) {
            addCriterion("rp_email in", values, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailNotIn(List<String> values) {
            addCriterion("rp_email not in", values, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailBetween(String value1, String value2) {
            addCriterion("rp_email between", value1, value2, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpEmailNotBetween(String value1, String value2) {
            addCriterion("rp_email not between", value1, value2, "rpEmail");
            return (Criteria) this;
        }

        public Criteria andRpAgeIsNull() {
            addCriterion("rp_age is null");
            return (Criteria) this;
        }

        public Criteria andRpAgeIsNotNull() {
            addCriterion("rp_age is not null");
            return (Criteria) this;
        }

        public Criteria andRpAgeEqualTo(Integer value) {
            addCriterion("rp_age =", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeNotEqualTo(Integer value) {
            addCriterion("rp_age <>", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeGreaterThan(Integer value) {
            addCriterion("rp_age >", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rp_age >=", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeLessThan(Integer value) {
            addCriterion("rp_age <", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeLessThanOrEqualTo(Integer value) {
            addCriterion("rp_age <=", value, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeIn(List<Integer> values) {
            addCriterion("rp_age in", values, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeNotIn(List<Integer> values) {
            addCriterion("rp_age not in", values, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeBetween(Integer value1, Integer value2) {
            addCriterion("rp_age between", value1, value2, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("rp_age not between", value1, value2, "rpAge");
            return (Criteria) this;
        }

        public Criteria andRpCompanyIsNull() {
            addCriterion("rp_company is null");
            return (Criteria) this;
        }

        public Criteria andRpCompanyIsNotNull() {
            addCriterion("rp_company is not null");
            return (Criteria) this;
        }

        public Criteria andRpCompanyEqualTo(String value) {
            addCriterion("rp_company =", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyNotEqualTo(String value) {
            addCriterion("rp_company <>", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyGreaterThan(String value) {
            addCriterion("rp_company >", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("rp_company >=", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyLessThan(String value) {
            addCriterion("rp_company <", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyLessThanOrEqualTo(String value) {
            addCriterion("rp_company <=", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyLike(String value) {
            addCriterion("rp_company like", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyNotLike(String value) {
            addCriterion("rp_company not like", value, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyIn(List<String> values) {
            addCriterion("rp_company in", values, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyNotIn(List<String> values) {
            addCriterion("rp_company not in", values, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyBetween(String value1, String value2) {
            addCriterion("rp_company between", value1, value2, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpCompanyNotBetween(String value1, String value2) {
            addCriterion("rp_company not between", value1, value2, "rpCompany");
            return (Criteria) this;
        }

        public Criteria andRpOccupationIsNull() {
            addCriterion("rp_occupation is null");
            return (Criteria) this;
        }

        public Criteria andRpOccupationIsNotNull() {
            addCriterion("rp_occupation is not null");
            return (Criteria) this;
        }

        public Criteria andRpOccupationEqualTo(String value) {
            addCriterion("rp_occupation =", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationNotEqualTo(String value) {
            addCriterion("rp_occupation <>", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationGreaterThan(String value) {
            addCriterion("rp_occupation >", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("rp_occupation >=", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationLessThan(String value) {
            addCriterion("rp_occupation <", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationLessThanOrEqualTo(String value) {
            addCriterion("rp_occupation <=", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationLike(String value) {
            addCriterion("rp_occupation like", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationNotLike(String value) {
            addCriterion("rp_occupation not like", value, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationIn(List<String> values) {
            addCriterion("rp_occupation in", values, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationNotIn(List<String> values) {
            addCriterion("rp_occupation not in", values, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationBetween(String value1, String value2) {
            addCriterion("rp_occupation between", value1, value2, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpOccupationNotBetween(String value1, String value2) {
            addCriterion("rp_occupation not between", value1, value2, "rpOccupation");
            return (Criteria) this;
        }

        public Criteria andRpIndustryIsNull() {
            addCriterion("rp_industry is null");
            return (Criteria) this;
        }

        public Criteria andRpIndustryIsNotNull() {
            addCriterion("rp_industry is not null");
            return (Criteria) this;
        }

        public Criteria andRpIndustryEqualTo(String value) {
            addCriterion("rp_industry =", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryNotEqualTo(String value) {
            addCriterion("rp_industry <>", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryGreaterThan(String value) {
            addCriterion("rp_industry >", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("rp_industry >=", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryLessThan(String value) {
            addCriterion("rp_industry <", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryLessThanOrEqualTo(String value) {
            addCriterion("rp_industry <=", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryLike(String value) {
            addCriterion("rp_industry like", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryNotLike(String value) {
            addCriterion("rp_industry not like", value, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryIn(List<String> values) {
            addCriterion("rp_industry in", values, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryNotIn(List<String> values) {
            addCriterion("rp_industry not in", values, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryBetween(String value1, String value2) {
            addCriterion("rp_industry between", value1, value2, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpIndustryNotBetween(String value1, String value2) {
            addCriterion("rp_industry not between", value1, value2, "rpIndustry");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateIsNull() {
            addCriterion("rp_time_create is null");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateIsNotNull() {
            addCriterion("rp_time_create is not null");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateEqualTo(String value) {
            addCriterion("rp_time_create =", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateNotEqualTo(String value) {
            addCriterion("rp_time_create <>", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateGreaterThan(String value) {
            addCriterion("rp_time_create >", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateGreaterThanOrEqualTo(String value) {
            addCriterion("rp_time_create >=", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateLessThan(String value) {
            addCriterion("rp_time_create <", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateLessThanOrEqualTo(String value) {
            addCriterion("rp_time_create <=", value, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateIn(List<String> values) {
            addCriterion("rp_time_create in", values, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateNotIn(List<String> values) {
            addCriterion("rp_time_create not in", values, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateBetween(String value1, String value2) {
            addCriterion("rp_time_create between", value1, value2, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeCreateNotBetween(String value1, String value2) {
            addCriterion("rp_time_create not between", value1, value2, "rpTimeCreate");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyIsNull() {
            addCriterion("rp_time_modify is null");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyIsNotNull() {
            addCriterion("rp_time_modify is not null");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyEqualTo(String value) {
            addCriterion("rp_time_modify =", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyNotEqualTo(String value) {
            addCriterion("rp_time_modify <>", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyGreaterThan(String value) {
            addCriterion("rp_time_modify >", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyGreaterThanOrEqualTo(String value) {
            addCriterion("rp_time_modify >=", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyLessThan(String value) {
            addCriterion("rp_time_modify <", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyLessThanOrEqualTo(String value) {
            addCriterion("rp_time_modify <=", value, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyIn(List<String> values) {
            addCriterion("rp_time_modify in", values, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyNotIn(List<String> values) {
            addCriterion("rp_time_modify not in", values, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyBetween(String value1, String value2) {
            addCriterion("rp_time_modify between", value1, value2, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpTimeModifyNotBetween(String value1, String value2) {
            addCriterion("rp_time_modify not between", value1, value2, "rpTimeModify");
            return (Criteria) this;
        }

        public Criteria andRpYnIsNull() {
            addCriterion("rp_yn is null");
            return (Criteria) this;
        }

        public Criteria andRpYnIsNotNull() {
            addCriterion("rp_yn is not null");
            return (Criteria) this;
        }

        public Criteria andRpYnEqualTo(Integer value) {
            addCriterion("rp_yn =", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnNotEqualTo(Integer value) {
            addCriterion("rp_yn <>", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnGreaterThan(Integer value) {
            addCriterion("rp_yn >", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnGreaterThanOrEqualTo(Integer value) {
            addCriterion("rp_yn >=", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnLessThan(Integer value) {
            addCriterion("rp_yn <", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnLessThanOrEqualTo(Integer value) {
            addCriterion("rp_yn <=", value, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnIn(List<Integer> values) {
            addCriterion("rp_yn in", values, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnNotIn(List<Integer> values) {
            addCriterion("rp_yn not in", values, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnBetween(Integer value1, Integer value2) {
            addCriterion("rp_yn between", value1, value2, "rpYn");
            return (Criteria) this;
        }

        public Criteria andRpYnNotBetween(Integer value1, Integer value2) {
            addCriterion("rp_yn not between", value1, value2, "rpYn");
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