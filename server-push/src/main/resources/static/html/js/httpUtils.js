/**
 * Created by houcunlu on 2017/8/22.
 */

var comment;
if (!comment)
    comment = {};


/**
 * post提交事件
 * @param url   地址
 * @param params    参数
 * @param msg   提示信息
 * @param success   成功回调
 */
comment.post = function (url, params, msg, success) {
    if (msg == null)
        msg = '加载中...';
    $.blockUI(
        {
            message: msg,
            baseZ: 2000,
            css: {
                border: 'none',
                padding: '15px',
                backgroundColor: 'white',
                width: "300px",
                opacity: .5,
                color: 'black'
            }
        });
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        contentType:"application/json",
        success: function(data){
            $.unblockUI();
            success(data);
        }
    });
}





/**
 * 判断输入是否为数字
 * @param v
 * @returns {boolean}
 */
function isNumber(str) {
    var reg = parseFloat(str);
    var re = /^\+?[0-9][0-9]*$/;
    if (!re.test(str)) {
        return false;
    }
    return !isNaN(reg);
}




/**
 * 非空验证
 * @param v
 * @returns {boolean}
 */
function isNull(v) {
    if(v==undefined || v=="" || v==null){
        return true;
    }
    return false;
}











