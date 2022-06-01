import HttpClient from "../utils/HttpClient";
import {api} from "./api";
import Moment from 'moment';

export const getSharingDiscountList = (data) => {
    return HttpClient.doGet(
        api.getUserSharingDiscountList + "page=" + data.page + "&size=" + data.size
    );
};
// START PUBLIC HOLIDAY API
export const getPublicHolidays = () => {
    return HttpClient.doGet(api.holiday);
};
export const getPublicHolidaysPage = (data) => {
    return HttpClient.doGet(
        api.holiday,
        data && data.page && data.size
            ? "?page=" + data.page + "&size=" + data.size
            : ""
    );
};
export const isOrderDay = (data) => {
    return HttpClient.doGet(
        api.isOrderDay + Moment(data.date).format("DD-MM-YYYY")
    );
};
export const addPublicHolidays = (data) => {
    return HttpClient.doPost(api.holiday, data);
};
export const saveHolidays = (data) => {
    return HttpClient.doPost(api.holidays, data);
};
export const editPublicHolidays = (data) => {
    return HttpClient.doPatch(api.holiday + "/" + data.id, data);
};

export const deletePublicHolidays = (data) => {
    return HttpClient.doDelete(api.holiday + "/" + data.id, data);
};
export const addFirstService = () => {
    return HttpClient.doPost(api.service + "firstService")
}

// FINISH PUBLIC HOLIDAY API

//Start Country api

export const getQrCodeForClient = () => {
    return HttpClient.doGet(api.getQrCodeForClient);
};
export const getUserSharingDiscount = () => {
    return HttpClient.doGet(api.getUserSharingDiscount);
};

//Finish State api

//Start MainServiceWithPercent api
export const getMainServicesWithPercent = (param = {}) => {
    return HttpClient.doGet(api.mainServicesWithPercent, param);
};
export const addMainServiceWithPercent = (data) => {
    return HttpClient.doPost(api.mainServicesWithPercent, data);
};
export const editMainServiceWithPercent = (data) => {
    return HttpClient.doPatch(api.mainServicesWithPercent + "/" + data.id, data);
};

export const deleteMainServiceWithPercent = (data) => {
    return HttpClient.doDelete(api.mainServicesWithPercent + "/" + data.id, data);
};
//Finish MainServiceWithPercent api

//Start PayType api
export const getPayType = (param = {}) => {
    return HttpClient.doGet(api.payType, param);
};
export const addPayType = (data) => {
    return HttpClient.doPost(api.payType, data);
};
export const editPayType = (data) => {
    return HttpClient.doPatch(api.payType + data.id, data);
};

export const deletePayType = (data) => {
    return HttpClient.doDelete(api.payType + data.id, data);
};
//Finish MainServiceWithPercent api

//-----------------------------------------------------------------------------------------------------//

//Start Country api
export const getCountries = (data) => {
    return HttpClient.doGet(
        api.getCountryList +
        (data && data.page && data.size
            ? "?page=" + data.page + "&size=" + data.size + "&sort=name"
            : "?page=0&size=20&sort=name")
    );
};
export const getZipCode = (data) => {
    return HttpClient.doGet(api.zipCode + data);
};
export const getUsersByZipCode = (data) => {
    return HttpClient.doGet(api.user + "/getUsersByZipCode/" + data);
};
export const addDiscount = (data) => {
    return HttpClient.doPost(api.discount, data);
};
export const editDiscount = (data) => {
    return HttpClient.doPut(api.discount, data);
};
export const addCountry = (data) => {
    return HttpClient.doPost(api.addCountry, data);
};
export const editCountry = (data) => {
    return HttpClient.doPut(api.editCountry + data.id, data);
};
export const deleteCountry = (data) => {
    return HttpClient.doDelete(api.deleteCountry + data.id, data);
};

export const getPartners = () => {
    return HttpClient.doGet(api.partner);
};
export const getPartnerForHome = () => {
    return HttpClient.doGet(api.partner + '/search/home');
};

export const addPartner = (data) => {
    return HttpClient.doPost(api.partner, data);
};

export const editPartner = (data) => {
    return HttpClient.doPut(api.partner + "/" + data.id, data);
};

export const deletePartner = (id) => {
    return HttpClient.doDelete(api.partner + "/" + id);
};

export const addUserZipcode = (data) => {
    return HttpClient.doPut(api.agent + "userZipCode" + (data.userId ? "?agentId=" + data.userId : ''), data.zipCodes);
};
export const getUserZipcodesByUser = () => {
    return HttpClient.doGet(api.agent + "userZipCode");
}
export const getUserZipcodesByUserForAdmin = (id) => {
    return HttpClient.doGet(api.agent + "userZipCode/" + id);
};

export const changeEnableUserZipcode = (data) => {
    return HttpClient.doPut(api.agent + "userZipCode/enable/" + data);
};
export const changeActiveUserZipcode = (data) => {
    return HttpClient.doPut(api.agent + "userZipCode/active/" + data);
};
export const getZipCodeByCertificate = () => {
    return HttpClient.doGet(api.agent + "zipCode");
};
export const getZipCodeByCertificateForAdmin = (id) => {
    return HttpClient.doGet(api.agent + "zipCode?agentId=" + id);
};


//Finish Country api

//Start State api
export const getStates = (param = {}) => {
    return HttpClient.doGet(api.state, param);
};
export const addState = (data) => {
    return HttpClient.doPost(api.state, data);
};
export const editState = (data) => {
    return HttpClient.doPut(api.state + data.id, data);
};

export const deleteState = (data) => {
    return HttpClient.doDelete(api.state + data.id, data);
};
//Finish State api

//Start County api
export const getCounties = (param = {}) => {
    return HttpClient.doGet(api.county, param);
};
export const addCounty = (data) => {
    return HttpClient.doPost(api.county, data);
};
export const editCounty = (data) => {
    return HttpClient.doPatch(api.county + data.id, data);
};

export const deleteCounty = (data) => {
    return HttpClient.doDelete(api.county + data.id, data);
};
//Finish County api

//Start Passport
export const addPassport = (data) => {
    return HttpClient.doPost(api.passport, data);
};
export const editPassport = (data) => {
    return HttpClient.doPut(api.passport, data);
};
export const addCertificate = (data) => {
    return HttpClient.doPost(api.certificates, data);
};
export const editCertificate = (data) => {
    return HttpClient.doPut(api.certificates, data);
};
export const addFeedBack = (data) => {
    return HttpClient.doPost(api.feedBack, data);
};
export const editFeedBack = (data) => {
    return HttpClient.doPut(api.feedBack, data);
};
export const addAnswer = (data) => {
    return HttpClient.doPost(api.feedBack + "/answer", data);
};
export const getFeedBacks = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.feedBack + "?" + param);
};
export const getCustomers = (data) => {
    // let param = ''
    // Object.entries(data).map(([key, value]) => param = param + key + '=' + value + '&&')
    return HttpClient.doGet(
        api.user + "/getCustomers?page=" + data.page + "&size=" + data.size,
        data
    );
};
export const getFeedBackByUser = (data) => {
    return HttpClient.doGet(api.feedBack + "/byUserId?" + makeParam(data));
};
export const getFeedBackMaxRate = (data) => {
    return HttpClient.doGet(api.feedBack + "/maxRate?" + makeParam(data));
};
export const getDiscountList = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.discount + "?" + param);
};
export const getDiscountByUser = (data) => {
    return HttpClient.doGet(api.discount + "/byUserId/" + data);
};
export const changeActiveAgent = (data) => {
    return HttpClient.doPut(
        api.agent + "changeActiveAgent/" + data.id,
        data.counties
    );
};
export const changeActiveOnlineAgent = (data) => {
    return HttpClient.doPut(
        api.agent + "changeOnline/" + data.id + "?onlineAgent=" + data.onlineAgent
    );
};

//Finish Passport

// Attachment Started
export const uploadFile = (data) => {
    return HttpClient.doPost(api.addAttachment, data);
};
export const removePhoto = (data) => {
    return HttpClient.doPost(api.user + "/removePhoto/" + data);
};
export const addPhoto = (data) => {
    return HttpClient.doPost(
        api.user + "/addPhoto/" + (data.userId ? data.userId + "/" : "") + data.attach
    );
};

export const deleteUploadedPhoto=(data) =>{
    return HttpClient.doGet(api.deleteUploadedPhoto +  data);
}

export const downloadFile = (data) => {
    return HttpClient.doGet(api.attachment + "/" + data.type + data.url);
};
// Attachment Finish

export const registerAgent = (data) => {
    return HttpClient.doPost(api.registerAgent, data);
};
export const editAgent = (data) => {
    return HttpClient.doPut(api.agent + "editAgent", data);
};
export const editAgentOwn = (data) => {
    return HttpClient.doPut(api.agent + "editAgentOwn", data);
};

export const getAgents = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getAgents + "?" + param);
};

export const getDeletedAgents = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getDeletedAgents + "?" + param);
};
export const deleteCorporate = (params) => {
    return HttpClient.doDelete(api.deleteCorporate + params);
};
export const deleteAgent = (params) => {
    return HttpClient.doDelete(api.deleteAgent + params);
};
export const deleteCustomer = (params) => {
    return HttpClient.doDelete(api.deleteCustomer + params);
};
export const saveCorporateUser = (data) => {
    return HttpClient.doPost(api.saveCorporateUser, data);
};
export const deleteEmployee = (params) => {
    return HttpClient.doDelete(api.deleteEmployee + params);
};
export const checkEmailAndPhone = (data) => {
    return HttpClient.doPost(api.exist, data);
};
export const addOrEditAgentService = (data) => {
    return HttpClient.doPost(api.agent + "service", data);
};
export const getAgentService = (data) => {
    let path = data ? "service?agentId=" + data : "service";
    return HttpClient.doGet(api.agent + path, data);
};

export const getAgentsBySearch = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getAgents + "/search?" + param);
};

export const getDeletedAgentsBySearch = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getDeletedAgents + "/search?" + param);
};

export const getUsersBySearch = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.user + "/customer/search?" + param);
};
export const getDeletedUsersBySearch = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.user + "/deletedCustomer/search?" + param);
};
export const getEmployeesBySearch = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.user + "/employees/search?" + param);
};

export const getAgentsByFilter = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getAgents + "/filter?" + param);
};
export const getCustomersByFilter = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.getCustomers + "/filter?" + param);
};
export const getAgentById = (id) => {
    return HttpClient.doGet(api.getAgent + id, {});
};

export const getEmbassy = (data) => {
    return HttpClient.doGet(api.getCountryList + "/search/embassy?embassy=" + (!!data));
};

export const editProfile = (data) => {
    return HttpClient.doPut(api.editCorporateAdmin + data.id + '?admin=' + data.bool, data);
};

export const editUser = (data) => {
    return HttpClient.doPut(api.editUser, data);
};

export const getPassportsByUserId = (id) => {
    return HttpClient.doGet(
        api.getAgent +
        "passport/byUserId" +
        (id == null ? "/6cf88f74-a54c-420e-a8e1-10259b902a28" : "/" + id),
        {}
    );
};
export const getCertificatesByUserId = (id) => {
    return HttpClient.doGet(
        api.getAgent +
        "certificate/byUserId" +
        (id == null ? "/6cf88f74-a54c-420e-a8e1-10259b902a28" : "/" + id),
        {}
    );
};
export const changeStatusDocument = (data) => {
    return HttpClient.doPut(
        api.changeStatusDocument +
        "?documentId=" +
        data.documentId +
        "&statusEnum=" +
        data.statusEnum +
        "&description=" +
        data.description
    );
};
// Start ServicePrice api
export const getServicePrice = (data = {}) => {
    return HttpClient.doGet(api.servicePrice + "/page", data);
};
export const getServicePriceDashboard = (data = {}) => {
    return HttpClient.doGet(api.servicePrice + "/dashboard", data);
};
export const getServiceByState = (param = {}) => {
    return HttpClient.doGet(
        api.servicePrice + "/byState" + "?serviceId=" + param.service.id,
        param
    );
};
export const getCountyByState = (param = {}) => {
    return HttpClient.doGet(
        api.servicePrice + "/byState" + "?stateId=" + param.option.value,
        param
    );
};
export const getCountyByStateForCalendar = (param = {}) => {
    return HttpClient.doGet(
        api.servicePrice + "/byState" + "?stateId=" + param,
        param
    );
};
export const getZipCodeByCounty = (param = {}) => {
    return HttpClient.doGet(
        api.servicePrice + "/byCounty" + "?countyId=" + param.option.value,
        param
    );
};
export const getZipCodeByCountyForCalendar = (param = {}) => {
    return HttpClient.doGet(
        api.servicePrice + "/byCounty" + "?countyId=" + param,
        param
    );
};
export const addServicePrice = (data) => {
    return HttpClient.doPost(api.servicePrice, data);
};
export const editServicePrice = (data) => {
    return HttpClient.doPut(api.servicePrice + "/editServicePrice", data);
};
export const editServicePriceActive = (data) => {
    return HttpClient.doPut(api.servicePrice + "/editServicePriceActive", data);
};
//Finish ServicePrice api

// Start Pricing api
export const getPricing = (data = {}) => {
    return HttpClient.doGet(api.pricing + "/page", data);
};
export const getStateByPricing = (data) => {
    return HttpClient.doGet(api.pricing + "/getStateByPricing?serviceId=" + data);
};
export const getPricingByState = (data) => {
    return HttpClient.doGet(api.pricing + "/stateByPricing?stateId=" + data.stateId);
};
export const deletePricing = (data) => {
    return HttpClient.doDelete(api.pricing + "/deletePricing?fromCount=" + data.fromCount + "&tillCount=" + data.tillCount + "&everyCount=" + data.everyCount + "&stateId=" + data.stateId + "&price=" + data.price + "&subServiceName=" + data.subServiceName);
};
export const getDashboardPricing = (data = {}) => {
    return HttpClient.doGet(api.pricing + "/dashboard", data);
};
export const addPricing = (data) => {
    return HttpClient.doPost(api.pricing, data);
};
export const addRealEstate = (data) => {
    return HttpClient.doPost(api.realEstate, data);
};
export const addInternational = (data) => {
    return HttpClient.doPost(api.international, data);
};
export const editPricing = (data) => {
    return HttpClient.doPut(api.pricing + "/editPrice", data);
};
//Finish Pricing api

//Start Service api
export const getServices = (param = {}) => {
    return HttpClient.doGet(api.service + "getServiceList", param);
};
export const getServicePage = (data) => {
    return HttpClient.doGet(
        api.service + "getPage?page=" + data.page + "&size=" + data.size
    );
};
export const getServicesByServicePrice = (data = {}) => {
    return HttpClient.doGet(api.service + "getService", data);
};
export const addService = (data) => {
    return HttpClient.doPost(api.service, data);
};
export const editService = (data) => {
    return HttpClient.doPut(api.service + "editService", data);
};
export const editServiceChangeActive = (data) => {
    return HttpClient.doPut(api.service + "changeActive/" + data.serviceId);
};
export const deleteService = (data) => {
    return HttpClient.doDelete(
        api.service +
        "delete?serviceId=" +
        data.id +
        "&subServiceId=" +
        data.subServiceDto.id
    );
};
//Finish Service api

//-----------------------------------------------------------------------------------------------------//

//Start category api
export const getCategory = (param = {}) => {
    return HttpClient.doGet(api.category, param);
};

export const addCategory = (data) => {
    return HttpClient.doPost(api.category, data);
};
export const editCategory = (data) => {
    return HttpClient.doPatch(api.category + data.id, data);
};

export const deleteCategory = (data) => {
    return HttpClient.doDelete(api.category + data.id, data);
};
//Finish category api

//Start MainService api
export const getMainServices = (param = {}) => {
    return HttpClient.doGet(api.mainService, param);
};

export const addMainService = (data) => {
    return HttpClient.doPost(api.mainService, data);
};
export const editMainService = (data) => {
    return HttpClient.doPut(api.editMainService + data.id, data);
    return
};

export const deleteMainService = (data) => {
    return HttpClient.doDelete(api.mainService + data.id, data);
};
//Finish MainService api

//Start TermsOf api
export const getTerms = (data) => {
    return HttpClient.doGet(api.blog + "/terms/" + data, data);
};

export const editTerms = (data) => {
    return HttpClient.doPut(api.blog + "/terms/edit/" + data.id, data);
};
//Finish TermsOf api

// Start Blog api
export const getBlog = (data) => {
    return HttpClient.doGet(api.blog + "/" + data.id);
};
export const getBlogUrl = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.blog + "?" + param);
};
export const getBlogByCategory = (data) => {
    return HttpClient.doGet(api.blog + "/byCategory/" + data.id);
};
export const getBlogAll = (data) => {
    return HttpClient.doGet(
        api.blog + "/all?page=" + data.page + "&size=" + data.size
    );
};
export const getBlogFeatured = (data) => {
    return HttpClient.doGet(api.blog + "/featured", data);
};

export const addBlog = (data) => {
    return HttpClient.doPost(api.blog, data);
};
export const editBlog = (data) => {
    return HttpClient.doPut(api.blog + "/edit/" + data.id, data);
};

export const deleteBlog = (data) => {
    return HttpClient.doDelete(api.blog + "/" + data.id, data);
};

export const addDynamic = (data) => {
    return HttpClient.doPost(api.blog + "/dynamic", data);
};
export const editDynamic = (data) => {
    return HttpClient.doPut(api.blog + "/edit/dynamic/" + data.id, data);
};
export const getDynamic = (data) => {
    return HttpClient.doGet(
        api.blog + "/dynamic/all?page=" + data.page + "&size=" + data.size
    );
};

//Finish Blog api

//-----------------------------------------------------------------------------------------------------//

//Start SubService api
export const getSubServices = (param = {}) => {
    return HttpClient.doGet(api.subService, param);
};
export const getSubServicePage = (data) => {
    return HttpClient.doGet(
        api.service + "subServicePageable?page=" + data.page + "&size=" + data.size
    );
};
export const addSubService = (data) => {
    return HttpClient.doPost(api.subService, data);
};
export const editSubService = (data) => {
    return HttpClient.doPut(api.service + "editSubService", data);
};

export const deleteSubService = (data) => {
    return HttpClient.doDelete(api.subService + data.id, data);
};
//Finish SubService api

// Start ZipCodes api
export const getZipCodes = (param = {}) => {
    return HttpClient.doGet(api.zipCode, param);
};
export const addZipCode = (data) => {
    return HttpClient.doPost(api.zipCode, data);
};
export const editZipCode = (data) => {
    return HttpClient.doPut(api.zipCode, data);
};

export const deleteZipCode = (param = {}) => {
    return HttpClient.doDelete(api.zipCode + param.id, param);
};
export const addOrEditUserZipCode = (data) => {
    return HttpClient.doPost(api.user + "/editAdminZipCode", data);
};
//Finish ZipCodes api
//Start TimeBooked
export const getTimeBooked = (param = {}) => {
    return HttpClient.doGet(api.timeBooked + "?size=1&sort=id,desc", param);
};
export const addTimeBooked = (data) => {
    return HttpClient.doPost(api.timeBooked, data);
};
export const editTimeBooked = (data) => {
    return HttpClient.doPatch(api.timeBooked + data.id, data);
};
export const deleteTimeBooked = (param = {}) => {
    return HttpClient.doDelete(api.timeBooked + param.id, param);
};
//Finish TimeBooked

// Start TimeDuration
export const getTimeDuration = (param = {}) => {
    return HttpClient.doGet(api.timeDuration + "?size=1&sort=id,desc", param);
};
export const addTimeDuration = (data) => {
    return HttpClient.doPost(api.timeDuration, data);
};
export const editTimeDuration = (data) => {
    return HttpClient.doPatch(api.timeDuration + data.id, data);
};
export const deleteTimeDuration = (param = {}) => {
    return HttpClient.doDelete(api.timeDuration + param.id, param);
};
//Finish TimeDuration

//Start DiscountPercent api
export const getDiscountPercent = (param = {}) => {
    return HttpClient.doGet(api.discountPercent, param);
};
export const getDiscountPercentPage = (data) => {
    return HttpClient.doGet(
        api.service +
        "discountPercentPageable?page=" +
        data.page +
        "&size=" +
        data.size
    );
};
export const addDiscountPercent = (data) => {
    return HttpClient.doPost(api.discounts + "/saveDiscountPercent", data);
};
export const editDiscountPercent = (data) => {
    return HttpClient.doPut(
        api.discounts + "/editDiscountPercent/" + data.id,
        data
    );
};
export const getAgentDiscount = (data) => {
    return HttpClient.doGet(api.getAgentDiscount + "?search=" + data.search)
}
export const resetAgentDiscount = (data) => {
    return HttpClient.doPost(api.resetAgentDiscount, data)
}
export const deleteDiscountPercent = (data) => {
    return HttpClient.doDelete(api.discountPercent + "/" + data.id, data);
};
//Finish DiscountPercent api

// Start WeekDay api
export const getWeekDay = (param = {}) => {
    return HttpClient.doGet(api.weekDay + "?sort=orderNumber", param);
};
export const addWeekDay = (data) => {
    return HttpClient.doPost(api.weekDay, data);
};
export const editWeekDay = (data) => {
    return HttpClient.doPatch(api.weekDay + data.id, data);
};
//Finish WeekDay api

// Start AgentSchedule api
export const getAgentSchedule = (agentId) => {
    return HttpClient.doGet(agentId ? (api.agentSchedule + "byAgent?agentId=" + agentId) : api.agentSchedule + "byAgent");
};
export const addAgentSchedule = (data) => {
    return HttpClient.doPost(api.agentSchedule, data);
};
export const editAgentSchedule = (data) => {
    return HttpClient.doPost(api.agentSchedule, data);
};
export const changeScheduleDayOff = (data) => {
    return HttpClient.doPatch(
        `${api.agentSchedule}agentDayOff?agentScheduleId=${data.id}&dayOff=${data.dayOff}`
    );
};
export const changeScheduleHourOff = (data) => {
    return HttpClient.doPatch(
        `${api.agentSchedule}agentHourOff?from=${data.from}&till=${data.till}`
    );
};
export const deleteAgentSchedule = (data) => {
    return HttpClient.doDelete(api.agentSchedule + data.id, data);
};
export const getDaylySchedules = (data) => {
    return HttpClient.doGet(`${api.agentSchedule}daylySchedule?date=` + data);
};

//Finish AgentSchedule api

//Start History api
export const getHistory = (data) => {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return HttpClient.doGet(api.history + "?" + param);
};
export const getHistoryTables = (param = {}) => {
    return HttpClient.doGet(api.historyTables, param);
};
export const getAuditItemForTable = (data = {}) => {
    return HttpClient.doGet(
        api.getAuditItemForTable +
        data.tableName +
        "/snapshots" +
        (data.page ? "?page=" + data.page + "&size=" + data.size : "")
    );
};
//Finish History api
//Start Audit api
export const getAudit = (data) => {
    return HttpClient.doGet(
        api.audit + "?page=" + data.page + "&size=" + data.size
    );
};
export const getAuditTables = () => {
    return HttpClient.doGet(api.auditTables);
};

export const getAuditForItemWithCommitId = (data = {}) => {
    return HttpClient.doGet(
        api.getAuditForItemWithCommitId +
        "?tableName=" +
        data.tableName +
        "&tableItemId=" +
        data.tableItemId +
        "&commitId=" +
        data.commitId.toString()
    );
};
export const getUserForAudit = (data = {}) => {
    return HttpClient.doGet(api.getUserForAudit + data.id);
};
export const getOneItemForAudit = (data = {}) => {
    return HttpClient.doGet(
        api.getOneItemAudit + data.id + "?page=" + data.page + "&size=" + data.size
    );
};
export const getItemByAuthor = (data = {}) => {
    return HttpClient.doGet(
        api.getItemByAuthor + data.id + "?page=" + data.page + "&size=" + data.size
    );
};
export const getTotalElementsCount = (data = {}) => {
    return HttpClient.doGet(
        api.getTotalElementsCount +
        (data.tableName
            ? "?tableName=" + data.tableName
            : data.id
                ? data.admin
                    ? "?id=" + data.id + "&admin=" + data.admin
                    : "?id=" + data.id
                : "")
    );
};
//Finish History api
//Start documentType api
export const getDocumentType = (param = {}) => {
    return HttpClient.doGet(api.documentType, param);
};
export const getDocumentTypePage = (data) => {
    return HttpClient.doGet(
        api.service +
        "documentTypePageable?page=" +
        data.page +
        "&size=" +
        data.size
    );
};
export const addDocumentType = (data) => {
    return HttpClient.doPost(api.documentType, data);
};
export const editDocumentType = (data) => {
    return HttpClient.doPatch(api.documentType + data.id, data);
};

export const deleteDocumentType = (data) => {
    return HttpClient.doDelete(api.documentType + data.id, data);
};
//Finish documentType api

//Start Additional Service api
export const getAdditionalServices = (param = {}) => {
    return HttpClient.doGet(api.additionalService, param);
};
export const getAdditionalServicePage = (data) => {
    return HttpClient.doGet(
        api.service +
        "additionalServicePageable?page=" +
        data.page +
        "&size=" +
        data.size
    );
};
export const addAdditionalService = (data) => {
    return HttpClient.doPost(api.additionalService, data);
};
export const editAdditionalService = (data) => {
    return HttpClient.doPatch(api.additionalService + data.id, data);
};

export const deleteAdditionalService = (data) => {
    return HttpClient.doDelete(api.additionalService + data.id, data);
};
//Finish Additional Service api
// Start Additional Service Price api
export const getAdditionalServicePrice = (data = {}) => {
    return HttpClient.doGet(api.additionalServicePrice + "getPage", data);
};
export const getAdditionalServicePriceDashboard = (data = {}) => {
    return HttpClient.doGet(api.additionalServicePrice + "dashboard", data);
};
export const addAdditionalServicePrice = (data) => {
    return HttpClient.doPost(api.additionalServicePrice, data);
};
export const editAdditionalServicePrice = (data) => {
    return HttpClient.doPut(
        api.additionalServicePrice + "editAdditionalServicePrice",
        data
    );
};
export const editAdditionalServicePriceActive = (data) => {
    return HttpClient.doPut(
        api.additionalServicePrice + "changeActive/" + data.id,
        data
    );
};

export const deleteAdditionalServicePrice = (data) => {
    return HttpClient.doDelete(api.additionalServicePrice + data.id, data);
};

//Payment for admin
export const getPayment = (data) => {
    return HttpClient.doGet(api.payment + "/admin?page=" + data.page + "&size=" + data.size)
}

export const getorderBySearch = (data) => {
    return HttpClient.doGet(api.order + '/search?serialNumber=' + data, {})
}

export const savePayment = (data) => {
    return HttpClient.doPost(api.payment, data)
}

export const deletePayment = (data) => {
    return HttpClient.doDelete(api.payment + '/' + data)
}
//Payment for admin

//Finish Additional Service Price api
function makeParam(data) {
    let param = "";
    Object.entries(data).map(
        ([key, value]) => (param = param + key + "=" + value + "&&")
    );
    return param;
}

// Admin Dashboard
export const getTotalNumbersForDashboard = () => {
    return HttpClient.doGet(api.dashboard + "events")
}

export const getOrdersCash = () => {
    return HttpClient.doGet(api.dashboard + "orders")
}

export const getDashboard = (data) => {
    return HttpClient.doGet(`${api.dashboard}filter?stateId=${data.stateId != null ? data.stateId : ''}&countyId=${data.countyId != null ? data.countyId : ''}&zipCodeId=${data.zipCodeId != null ? data.zipCodeId : ''}&date=${data.date}`)
}

//Review
export const getReviews = (data) => {
    return HttpClient.doGet(data ? api.review + "?page=" + data.page + "&size=" + data.size : "/review" + "?sort=updatedAt,desc");
}

export const deleteReview = (data) => {
    return HttpClient.doDelete(api.review + data)
}

export const addReview = (data) => {
    return HttpClient.doPost(api.review, data)
}

export const editReview = (data) => {
    return HttpClient.doPut(api.review + data.id, data)
}

//FAQ
export const getFaq = () => {
    return HttpClient.doGet(api.faq + "/get/all");
}

export const deleteFaq = (data) => {
    return HttpClient.doDelete(api.faq + "/delete/" + data)
}

export const addFaq = (data) => {
    return HttpClient.doPost(api.faq + "/add", data)
}

export const editFaq = (data) => {
    return HttpClient.doPut(api.faq + "/edit/" + data.id, data)
}
export const addCountryPrice = (data) => {
    return HttpClient.doPost(api.countryPrice, data);
}
export const getCountryPrice = () => {
    return HttpClient.doGet(api.countryPrice);
}
export const getNotifications = () => {
    return HttpClient.doGet(api.notification);
}
export const deleteNotification = (data) => {
    return HttpClient.doDelete(api.notification+ data);
}

export const getFeedbackById = (data) => {
    return HttpClient.doGet(api.feedBack+"/"+data);
}
export const getOneByNotification = (data) => {
    return HttpClient.doGet(api.feedBackByNotificationForAgent+data);
}
export const editCountryPrice = (data) => {
    return HttpClient.doPut(api.countryPrice + '/' + data.id, data);
}
export const deleteCountryPrice = (data) => {
    return HttpClient.doDelete(api.countryPrice + '/' + data.id);
}
export const changeActiveCountryPrice = (data) => {
    return HttpClient.doPost(api.countryPrice + '/search/enable?id=' + data.id + "&value=" + data.active);
}
export const changeOnlineAndOffline = (data) => {
    return HttpClient.doPut(api.user + '/changeOnlineAndOffline');
}

export const getServiceStateApi = (data) => {
    return HttpClient.doGet(api.getServiceStateApi + '/' + data)
}

export const getServiceCountyApi = (data) => {
    return HttpClient.doGet(api.getServiceCountyApi + '/' + data.id + '?currentServiceId=' + data.currentServiceId)
}

export const getServiceZipCodesApi = (data) => {
    return HttpClient.doGet(api.getServiceZipCodesApi + '/' + data.id + '?currentServiceId=' + data.currentServiceId)
}

export const popMessageModalApi=()=>{
    return HttpClient.doGet(api.popMessageModalApi)
}

export const saveEmergencyInfoAction=(data)=>{
    return HttpClient.doPost(api.saveEmergencyInfoAction,data)
}

export const editEmergencyInfoAction=(data)=>{
    return HttpClient.doPut(api.editEmergencyInfoAction,data)
}

export const getAgentEmergencyInfo=(data)=>{
    return HttpClient.doGet(api.getAgentEmergencyInfo+("/")+data)
}
export const seenAdmin=(data)=>{
    return HttpClient.doGet(api.agent+"service/seen?"+makeParam(data))
}
