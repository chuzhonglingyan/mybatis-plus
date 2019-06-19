var vm = new Vue({
    el: '#${modelNameLowerCamel}List',
    data: {
        url: {
            queryUrl: baseURL + "/${modelNameLowerCamel}/list",
            addUrl: baseURL + "/${modelNameLowerCamel}/add",
            updateUrl: baseURL + "/${modelNameLowerCamel}/update",
            isEnableUrl: baseURL + "/${modelNameLowerCamel}/isEnable",
            isStopUrl: baseURL + "/${modelNameLowerCamel}/isStop",
            deleteUrl: baseURL + "/${modelNameLowerCamel}/delete"
        },
        validator: {},
        rowData:null,
        add${modelNameLowerCamel}Modal:null
    },
    methods: {
        queryData: function () {
            var table = $('#${modelNameLowerCamel}Table');
            table.bootstrapTable('destroy');
            table.bootstrapTable({
                url: this.url.queryUrl,      //请求后台的URL（*）
                method: 'post',              //请求方式（*）
                dataType: 'json',
                contentType: "application/x-www-form-urlencoded",
                cache: false,                //是否使用缓存，默认为true
                sidePagination: "server",   //分页方式: client客户端分页，server服务端分页（*）
                pagination: true,
                pageList: [10, 25, 50, 100, 500],
                pageNumber: 1,
                pageSize: 10,
                striped: true, //每行表格的背景会显示灰白相间
                queryParams: function (params) { //查询的参数
                    return {
                        pageNum: (params.offset / params.limit) + 1,
                        pageSize: params.limit
                    };
                },
                columns: [{
                    title: "序号",
                    formatter: function (value, row, index) {
                        return index + 1;
                    },
                    align: 'center'
                }, {
                    field: '${modelNameLowerCamel}Name',
                    title: "${modelNameDesc}名称",
                    align: 'center'
                }, {
                    field: '${modelNameLowerCamel}Status',
                    title: "${modelNameDesc}状态",
                    align: 'center',
                    formatter: function (value, row, index) {
                        return formatStatus(value);
                    }
                }, {
                    field: 'remark',
                    title: "备注",
                    align: 'center',
                    formatter: function (value, row, index) {
                        return formatText(value);
                    }
                }, {
                    field: 'createTime',
                    title: "创建时间",
                    align: 'center',
                    formatter: function (value, row, index) {
                        return formatStrDate(value);
                    }
                }, {
                    field: 'updateTime',
                    title: "更新时间",
                    align: 'center',
                    formatter: function (value, row, index) {
                        return formatStrDate(value);
                    }
                }, {
                    title: "操作",
                    formatter: function option(value, row, index) {
                        var str = "";
                        str += "<button style='margin-left:15px' class='btn btn-xs btn-info' onclick='vm.edit${modelNameUpperCamel}(" + JSON.stringify(row) + ")'><i class=\"fa fa-pencil-square-o\" ></i>&nbsp;编辑</button> ";
                        if (row.${modelNameLowerCamel}Status === 1) {
                            str += "<button style='margin-left:15px' class='btn btn-xs btn-warning ' onclick='vm.freeze${modelNameUpperCamel}(" + row.id + ")'><i class=\"fa fa-ban\" ></i>禁用</button>";
                        } else {
                            str += "<button style='margin-left:15px' class='btn btn-xs btn-success ' onclick='vm.eable${modelNameUpperCamel}(" + row.id + ")'><i class=\"fa fa-play\" ></i>启用</button>";
                            str += "<button style='margin-left:15px' class='btn btn-xs btn-danger ' onclick='vm.delete${modelNameUpperCamel}(" + row.id + ")'><i class=\"fa fa-trash-o\" ></i>&nbsp;删除</button>";
                        }
                        return str;
                    },
                    align: 'center'
                }],
                onLoadSuccess: function (data) {
                    console.debug(data);
                },
                onLoadError: function () {
                    console.debug("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                }
            });
        },
        eable${modelNameUpperCamel}: function (id) {
            postFormFull(vm.url.isEnableUrl,{"id":id},function (data) {
                layer.msg("启用成功");
                vm.queryData();
            },function (msg) {
                layer.msg(msg);
            })
        },
        freeze${modelNameUpperCamel}: function (id) {
            postFormFull(vm.url.isStopUrl,{"id":id},function (data) {
                layer.msg("禁用成功");
                vm.queryData();
            },function (msg) {
                layer.msg(msg);
            })
        },
        edit${modelNameUpperCamel}: function (row) {
            vm.rowData=row;
            $('#${modelNameLowerCamel}Name').val(row.${modelNameUpperCamel}Name);
            $('#remark').val(row.remark);
            var  ${modelNameLowerCamel}Status=row.${modelNameUpperCamel}Status;
            $('input:radio[name="${modelNameLowerCamel}Status"][value='+${modelNameLowerCamel}Status+']').prop("checked", "checked");
            setModalTitle( vm.add${modelNameUpperCamel}Modal,"编辑${modelNameDesc}");
            showModal( vm.add${modelNameUpperCamel}Modal);
        },
        add${modelNameUpperCamel}: function () {
            vm.rowData=null;
            setModalTitle( vm.add${modelNameUpperCamel}Modal,"新增${modelNameDesc}");
            showModal( vm.add${modelNameUpperCamel}Modal);
        },
        delete${modelNameUpperCamel}: function (id) {
            //询问框
            layer.confirm('确定要删除？', {btn: ['确定', '取消']}, function () {
                postFormFull(vm.url.deleteUrl,{"id":id},function (data) {
                    layer.msg("删除成功");
                    vm.queryData();
                },function (msg) {
                    layer.msg(msg);
                })
            }, function () {
            });
        },
        save${modelNameUpperCamel}: function () {
            var  paramFrom= $('#add${modelNameUpperCamel}Form').serialize();

            vm.validator.validate();
            if (vm.validator.isValid()) {
                if (isEmpty(vm.rowData)) {
                    postFormFull(vm.url.addUrl,paramFrom,function (data) {
                        layer.msg("新增成功");
                        hideModal( vm.add${modelNameUpperCamel}Modal);
                        vm.queryData();
                    },function (msg) {
                        layer.msg(msg);
                    })
                }else {
                    var data = $.param({'id': vm.rowData.id}) + '&' + paramFrom;
                    postFormFull(vm.url.updateUrl,data,function (data) {
                        layer.msg("编辑成功");
                        hideModal( vm.add${modelNameUpperCamel}Modal);
                        vm.queryData();
                    },function (msg) {
                        layer.msg(msg);
                    })
                }
            }
        }
    },
    created: function () {

    },
    mounted: function () {
        this.queryData();
        this.add${modelNameUpperCamel}Modal=$('#add${modelNameUpperCamel}Modal');
        initModalListener();
    }
});




function initModalListener() {
    var  add${modelNameUpperCamel}Modal= $("#add${modelNameUpperCamel}Modal");
    showModalListener(add${modelNameUpperCamel}Modal,function () {
        initValidForm();
        vm.validator = $("#add${modelNameUpperCamel}Form").data("bootstrapValidator");
        console.debug("显示");
    });

    hideModalListener(add${modelNameUpperCamel}Modal,function () {
        console.debug("消失");
        $('#add${modelNameUpperCamel}Form')[0].reset();
        vm.validator.destroy();
    })
}

function initValidForm() {
    $('#add${modelNameUpperCamel}Form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            ${modelNameUpperCamel}Name: {
                message: '${modelNameDesc}验证失败',
                validators: {
                    notEmpty: {
                        message: '${modelNameDesc}名不能为空'
                    }
                }
            },
            remark: {
                validators: {

                }
            }
        }
    });
}
