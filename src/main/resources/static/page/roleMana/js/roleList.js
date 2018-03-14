/**
 * Created by caiyl on 2017/10/8.
 */
$(function () {

    var tool = [];

    tool.push({
        text: '新增', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
            // AJAX.POST('/models/newModel')
            //iframe窗
            layer.open({
                type: 2,
                title: '新增',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['80%', '60%'],
                offset: 't',
                content: ['/page/roleMana/addRole.html','no']
            });
        }
    });


    $("#jqGridList").jqGrid({
        url: "/role/",
        datatype: "json",
        mtype: "GET",
        styleUI: 'Bootstrap',
        toolbar: [true, "top", tool],
        colNames: ["id", "编码", "名称", "操作"],
        colModel: [
            { name: "id", width: 55,align: "center" },
            { name: "roleCode", width: 90 ,align: "center"},
            { name: "roleName", width: 80, align: "center" },
            { name:"action",width: 80,align:"center" ,formatter:function (cellvalue, options, rowObject) {
                var actionHtml=new Array();
                actionHtml.push("<button  class='btn btn-info'  onClick=\"edit('"+rowObject.id+"');\"  >编辑</button>");
                actionHtml.push("<button   class='btn btn-danger' style='margin-left: 5px' onClick=\"del('"+rowObject.id+"');\"  >删除</button>");
                return '<div class="btn-group btn-group-xs">'+actionHtml.join("")+'</div>';
            } }

        ],
        pager: "#jqGridPager",
        rowNum: 10,
        rowList: [10, 20, 30],
        viewrecords: true,
        height: "500",
        autowidth: true
    });

});

function search() {
    $("#jqGridList").jqGrid('setGridParam', {
        mtype: 'POST',
        url: '/role/',
        page:1,
        datatype: "json"
    }).trigger("reloadGrid");
};

function del(id) {
    //询问框
    layer.confirm('是否删除该数据', {
        btn: ['是','否'] //按钮
    }, function(){

        $.ajax({
            url:"/role/"+id,
            type:'delete',
            dataType:"json",
            data:null,
            success:function(result){
                layer.msg("删除成功");
                search();
            }

        })

    }, function(){


    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['80%', '80%'],
        offset: 't',
        content: 'editRole.html?id='+id
    });
}
