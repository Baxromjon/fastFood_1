import {toast} from "react-toastify";

export const uploadFile=(payload, key)=> async (dispatch)=>{
    if (!payload||!(payload.type.substring(0, payload.type.indexOf("/"))==="image")){
        toast.error("FIle must be img")
        return "";
    }
    let obj=new FormData();
    obj.append("file", payload);
    await dispatch({
        api:'http://localhost:8090/api/attachment',
        types:[

        ]

    })
}
