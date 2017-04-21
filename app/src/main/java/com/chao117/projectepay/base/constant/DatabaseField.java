package com.chao117.projectepay.base.constant;

/**
 * Created by chan on 19/04/2017.
 */

public interface DatabaseField {
    //general field
    String ID = "id";
    String U_ID = "u_id";
    String L_ID = "l_id";
    String C_ID = "c_id";
    String GS_ID = "gs_id";
    String B_ID = "b_id";
    String U_B_ID = "u_b_id";
    String U_S_ID = "u_s_id";
    String G_ID = "g_id";
    String TS_ID = "ts_id";
    String TT_ID = "tt_id";

    //table_user
    String U_ACCOUNT = "u_account";
    String U_PASSWORD = "u_password";
    String U_NAME = "u_name";
    String U_GENDER = "u_gender";
    String U_BIRTH_ = "u_birth";
    String U_PHONE = "u_phone";
    String U_HEADER = "u_header";
    String U_REMARK = "u_remark";
    String U_TIMESTAMP = "u_timestamp";

    //table_ship_address
    String SA_DETAIL = "sa_detail";
    String SA_REMARK = "sa_remark";
    String SA_TIMESTAMP = "sa_timestamp";

    //table_goods
    String G_NAME = "g_name";
    String G_PRICE = "g_price";
    String P_MAIN_ID = "p_main_id";
    String G_TIMESTAMP = "g_timestamp";

    //table_pics
    String P_URL = "p_url";
    String P_TIMESTAMP = "p_timestamp";

    //table_goods_state
    String GS_CONTENT = "gs_content";
    String GS_TIMESTAMP = "gs_timestamp";
    String GS_REMARK = "gs_remark";

    //table_location
    String L_NAME = "l_name";
    String L_REMARK = "l_remark";
    String L_CODE = "l_code";
    String L_PARENT_CODE = "l_parent_code";
    String L_TIMESTAMP = "l_timestamp";

    //table_category
    String C_NAME = "c_name";
    String C_CODE = "c_code";
    String C_PARENT_CODE = "c_parent_code";
    String C_REMARK = "c_remark";
    String C_TIMESTAMP = "c_timestamp";

    //table_brand
    String B_NAME = "b_name";
    String B_CODE = "b_code";
    String B_PARENT_CODE = "b_parent_code";
    String B_REMARK = "b_remark";
    String B_TIMESTAMP = "b_timestamp";

    //table_history
    String H_REMARK = "h_remark";
    String H_TIMESTAMP = "h_timestamp";

    //table_transaction
    String T_B_REMARK = "t_b_remark";
    String T_S_REMARK = "t_s_remark";
    String T_TIMESTAMP = "t_timestamp";

    //table_auction
    String A_STATE = "a_state";
    String A_REMARK = "a_remark";
    String A_TIMESTAMP = "a_timestamp";

    //table_trans_type
    String TT_CONTENT = "tt_content";
    String TT_REMARK = "tt_remark";
    String TT_TIMESTAMP = "tt_timestamp";

    //table_trans_state
    String TS_CONTENT = "ts_content";
    String TS_REMARK = "ts_remark";
    String TS_TIMESTAMP = "ts_timestamp";

    //table_follow
    String F_TIMESTAMP = "f_timestamp";

    //table_message
    String M_CONTENT = "m_content";
    String M_PRE_ID = "m_pre_id";
    String M_REMARK = "m_remark";
    String M_TIMESTAMP = "m_timestamp";

}
