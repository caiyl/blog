$(function () {
    initForm();
})
/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    var dat = $("form").serializeArray()

    $.ajax({
        url:"/role/",
        type:'put',
        dataType:"json",
        data:dat,
        success:function(result){
            layer.msg("修改成功");
        }
    })

}
function closeLayer() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

/**
 * 初始化表达数据
 */
function initForm() {
    $.get('/role/'+getUrlParam("id"),function (dat) {
        $("#id").val(dat.id);
        $("#roleCode").val(dat.roleCode);
        $("#roleName").val(dat.roleName);
    })
}