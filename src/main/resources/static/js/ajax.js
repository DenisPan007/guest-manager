function loadAxis(url, payload){
        jQuery.ajaxSetup({async:false});
        axisArrays = null;
        $.ajax({
            url:url,
            type:"POST",
            data:payload,
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(data){
                axisArrays = data;
            }
         })
         return axisArrays;
    }