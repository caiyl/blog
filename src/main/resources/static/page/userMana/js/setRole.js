$(function () {
    initForm();
})
/**
 * Created by caiyl on 2017/10/8.
 */
function save() {
    console.log(getUrlParam("userName"));
    var roles = $('#userRole option');
    var roleCode = [];
    for(var i = 0; i < roles.length;i++){
        roleCode.push(roles[i].value);
    }

    $.ajax({
        url:"/user/"+getUrlParam("userName"),
        type:'post',
        dataType:"json",
        contentType : 'application/json',
        data:JSON.stringify(roleCode),
        success:function(result){
            layer.msg("设置成功");
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
    $.get('/user/candidateRole/'+getUrlParam("userName"),function (dat) {
        for(var i = 0; i < dat.length; i++){
            $("#candidateRole").append('<option value="'+ dat[i].roleCode+'" style="width: 200px">'+ dat[i].roleName+'</option>');
        }
    })

    $.get('/user/userRole/'+getUrlParam("userName"),function (dat) {
        for(var i = 0; i < dat.length; i++){
            $("#userRole").append('<option value="'+ dat[i].roleCode+'" style="width: 200px">'+ dat[i].roleName+'</option>');
        }
    })
}

function add2UserRole() {
    var selectRoles = $('#candidateRole option:selected');
    for(var i = 0; i < selectRoles.length;i++){
        $("#candidateRole option[value='"+selectRoles[i].value+"']").remove();
        $("#userRole").append('<option value="'+ selectRoles[i].value+'" style="width: 200px">'+ selectRoles[i].text+'</option>');
    }

}function removeUserRole() {
    var selectRoles = $('#userRole option:selected');
    for(var i = 0; i < selectRoles.length;i++){
        $("#userRole option[value='"+selectRoles[i].value+"']").remove();
        $("#candidateRole").append('<option value="'+ selectRoles[i].value+'" style="width: 200px">'+ selectRoles[i].text+'</option>');
    }

}