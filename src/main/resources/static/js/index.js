/**
 * Created by caiyl on 2017/10/8.
 */
$(function () {

    var tool = [];

    tool.push({
        text: '新增流程', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
            // AJAX.POST('/models/newModel')
            //iframe窗
            layer.open({
                type: 2,
                title: '新增流程',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['60%', '30%'],
                offset: 't',
                content: ['/page/processMana/addProcess.html','no']
                // content: '/modeler.html?modelId=17504'
            });
        }
    });
    tool.push({
        text: '批量删除', iconCls: 'fa fa-plus icolor', btnCls: 'btn jqgrid-tool-btn', handler: function () {
            layer.msg('Hello World');
            AJAX.POST('/models/newModel')
        }
    });

    $("#jqGridList").jqGrid({
        url: "../process/models",
        datatype: "json",
        mtype: "GET",
        styleUI: 'Bootstrap',
        toolbar: [true, "top", tool],
        colNames: ["流程id", "流程名称", "版本", "流程key值", "是否已部署", "创建时间","更新时间","操作"],
        colModel: [
            { name: "id", width: 55,align: "center" },
            { name: "name", width: 90 ,align: "center"},
            { name: "version", width: 80, align: "center" },
            { name: "key", width: 80, align: "center" },
            { name: "name", width: 80, align: "center" },
            { name: "createTime", width: 150, align: "center" ,formatter:function(cellvalue, options, rowObject) {
                return Utils.formatDate(cellvalue)
            }},
            { name: "lastUpdateTime", width: 150, align: "center" ,formatter:function(cellvalue, options, rowObject) {
                return Utils.formatDate(cellvalue)
            }},
            { name:"action",align:"center" ,formatter:function (cellvalue, options, rowObject) {
                var actionHtml=new Array();
                actionHtml.push("<button  class='btn btn-info'  onClick=\"edit('"+rowObject.id+"');\"  >编辑</button>");
                actionHtml.push("<button   class='btn btn-danger' style='margin-left: 5px' onClick=\"delModel('"+rowObject.id+"');\"  >删除</button>");
                actionHtml.push("<button   class='btn btn-warning' style='margin-left: 5px' onClick=\"publish('"+rowObject.id+"');\"  >发布</button>");
                return '<div class="btn-group btn-group-xs">'+actionHtml.join("")+'</div>';
            } }
        ],
        pager: "#jqGridPager",
        rowNum: 10,
        rowList: [10, 20, 30],
        viewrecords: true,
        height: "100%",
        autowidth: true
    });

});

function search() {
    $("#jqGridList").jqGrid('setGridParam', {
        mtype: 'POST',
        url: '../process/models',
        page:1,
        datatype: "json"
    }).trigger("reloadGrid");
};

function delModel(id) {
    //询问框
    layer.confirm('是否删除该模型？', {
        btn: ['是','否'] //按钮
    }, function(){

        $.ajax({
            url:"/models/"+id,
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
        title: '编辑流程',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['100%', '100%'],
        offset: 't',
        content: '/modeler.html?modelId='+id
    });
}
function publish(id) {

    //询问框
    layer.confirm('是否发布该模型？', {
        btn: ['是','否'] //按钮
    }, function(){

        $.ajax({
            url:"/models/"+id+"/deployment",
            type:'post',
            dataType:"json",
            data:null,
            success:function(result){
                layer.msg("发布成功");
                search();
            }

        })

    }, function(){


    });
}