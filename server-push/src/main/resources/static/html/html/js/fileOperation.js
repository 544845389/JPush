

function loadTree() {

    var url = URL +  loadDirectory;
    comment.post( url  , null , '执行中....', function (res) {
        if(res != null && res != undefined && res.list.length != 0){
            $('#tree').treeview({
                    data: res.list,
                    onNodeSelected: function (event, data) {
                        if(data.type == 1 ){
                            showText(data.href);
                        }else{
                            $("#content").val("");
                        }
                    }
            });
        }else{
            hint('请先在 【云配置管理】中 下载云端配置！');
        }
    });
}


loadTree();




function showText(data) {
    var  params = {
        filePath:data
    }
    var url = URL +  loadFileTest;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res.text != ""){
            $("#content").val(res.text);
        }
    });
    
}


/**
 * 解密
 */
function  decrypt() {
   var value =  $("#decryptInput").val();
   if(value == "" || value == undefined){
       $("#decryptText").val("解密后的内容");
       return;
   }

    var  params = {
        text:value
    }

    var url = URL +  decryptText;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res.text != ""){
            $("#decryptText").val(res.text);
        }else{
            $("#decryptText").val("解密失败！");
        }
    });

}



/**
 * 加密
 */
function  encrypt() {
    var value =  $("#encryptInput").val();
    if(value == "" || value == undefined){
        $("#encryptText").val("加密后的内容");
        return;
    }

    var  params = {
        text:value
    }

    var url = URL +  encryptText;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res.text != ""){
            $("#encryptText").val(res.text);
        }else{
            $("#encryptText").val("加密失败!");
        }
    });

}






/**
 * 保存当前文件内容
 */
$("#saveFile").on('click',  function() {
    var nodes =  $('#tree').treeview('getSelected');
    if(nodes.length == 0){
            hint("请选中文件操作！");
            return;
    }
    var node = nodes[0];
    if(node.type == 0){
        hint("请选中文件操作！");
        return;
    }
    window.parent.openModal($("#saveFile-div").clone(true),function(modalp){modal = modalp});
})



/**
 * 保存当前文件内容
 */
$("#saveFile-button").on('click',  function() {
    modal.modal('hide');
    var filePath =  $('#tree').treeview('getSelected')[0].href;
    var content =   $("#content").val();
    var  params = {
        filePath:filePath,
        content:content
    }

    var url = URL +  saveFile;
    comment.post( url  , JSON.stringify(params) , '执行中....', function (res) {
        if(res != null && res != undefined && res == 1 ){
            hint('文件保存成功！');
        }else{
            hint('文件保存失败！');
        }
    });


})





/**
 *
 */
$("#pushFile").on('click',  function() {
    window.parent.openModal($("#pushFile-div").clone(true),function(modalp){modal = modalp});
})




/**
 * 提交当前库至云端
 */
$("#pushFile-button").on('click',  function() {
    modal.modal('hide');
    var url = URL +  pushWarehouse;
    comment.post( url  , null , '执行中....', function (res) {
        if(res != null && res != undefined && res == 1 ){
            hint('仓库push成功');
        }else{
            hint('仓库push失败！');
        }
    });


})





