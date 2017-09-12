import { TableColumnOptions } from "app/commons/table/TableColumnOptions";
import { LazyLoadEvent } from "primeng/primeng";

export class TableOptions<T> {
    path                :string;
    postData            :{};
    lazyLoadEvents      :LazyLoadEvent;

    tableName           :string;
    dataKey             :string;
    selectionMode       :string     = "single";
    onRowSelect         :Function   = function onRowSelect(){};
    rows                :number     = 5;
    paginator           :boolean    = true;
    pageLinks           :number     = 5;
    rowsPerPageOptions  :number[]   = [5,10,20,50];
    tableColumnOptions  :TableColumnOptions[]
    selectedObject :T;

    dataList            :T[]      = [];
    totalRecords        :number     = 0;
    onLazyLoad          :Function   = function onRowSelect(){};

    constructor(
        tableName           :string,
        path                :string,
        postData            :{},
        dataKey             :string,
        tableColumnOptions  :TableColumnOptions[]
    ){
        this.path               = path              ;
        this.postData           = postData          ;
        this.tableName          = tableName         ;
        this.dataKey            = dataKey           ;
        this.tableColumnOptions = tableColumnOptions;
    }
}
