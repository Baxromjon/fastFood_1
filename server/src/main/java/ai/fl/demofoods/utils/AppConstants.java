package ai.fl.demofoods.utils;

import org.springframework.data.domain.Sort;

public interface AppConstants {
    String TRY_AGAIN = "Please try again later";
    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "10";
    String DEFAULT_DYNAMICPAGE_SIZE = "12";
    String SORT_TYPE_BY_ID = "id";
    String SORT_TYPE_ASC = "false";
    String SORT_TYPE_DESC = "true";

    int MAX_PAGE_SIZE = 20;
    String DEFAULT_BEGIN_DATE_DATE = "2022-02-02";
    String DEFAULT_BEGIN_DATE = "2022-02-02 02:02:02.222000";
    String DEFAULT_END_DATE = "2100-02-02 02:02:02.222000";
    // NormalRate agar shundan past baho bolsa admonga habar boradi hech kim tegmasin
    int NORMAl_RATE = 4;
    // column boyicha sort
    String COLUMN_NAME_FOR_SORT = "createdAt";
    Sort.Direction ASC_OR_DECK = Sort.Direction.ASC;

    String DEFAULT_PASSWORD = "root123";
    //        String CLIENT_URl = "http://localhost:3000";
//    String CLIENT_URl = "http://70.32.24.165";
//    String CLIENT_URl = "https://duonotary.com";
//    String EMAIL_SEND_URl = "http://70.32.24.165:8090/api/email/";
//    String EMAIL_SEND_URl = "http://localhost:8090/api/email/";

    //ApiResponse
    String USER_SELECTED_NONE = "Selected nothing";
    String SUCCESS_MESSAGE = "Successfully saved";
    String CATCH_MESSAGE = "Error on Server";
    String ID_NOT_FOUND = "Id not found";
    String AGENT_NOT_FOUND = "Agent not found";
    String ALREADY_EXIST = "Already exist";
    String SUCCESS_EDITED = "Successfully edited";
    String MISSING_FIELD = "Please fill the all input";
    String ATTACK_RESPONSE = "Your client has issued a malformed or illegal request. That’s all we know.";



    int THUMBNAIL_IMAGE_WIDTH = 150; //150px
    int THUMBNAIL_IMAGE_HEIGHT = 150; //150px
    String THUMBNAIL_OUTPUT_FORMAT = "jpg";
}
