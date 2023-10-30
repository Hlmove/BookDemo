<template>
    <div id="container">
        <!--        {{ books }}-->
        <!--        <hr/>-->
        <!--        {{total}}-->
        <!-- 表格 -->
        <el-table v-loading="loading" :data="books" @selection-change="handleSelectionChange"
                  style="width: 100%; margin-top: 20px;" stripe border>
            <el-table-column type="selection" align="center" width="60" fixed="left">
            </el-table-column>
            <el-table-column prop="id" label="图书编号" align="center" width="80" fixed="left">
            </el-table-column>
            <el-table-column prop="name" label="图书名称" align="center" width="300">
            </el-table-column>
            <el-table-column prop="description" label="图书描述" align="center" width="300">
            </el-table-column>
            <el-table-column prop="author" label="图书作者" align="center" width="80">
            </el-table-column>
            <el-table-column prop="publisher" label="图书出版社" align="center" width="300">
            </el-table-column>
            <el-table-column prop="price" label="图书价格" align="center" width="80">
                <template slot-scope="scope">
                    <!--如果存在price就加一个“元”字-->
                    <span v-if="scope.row.price">{{ scope.row.price }}元</span>
                </template>
            </el-table-column>
            <el-table-column label="图书库存" align="center" width="80">
                <template slot-scope="scope">
                    <span v-if="scope.row.storeNum">{{ scope.row.storeNum }}本</span>
                </template>
            </el-table-column>
            <el-table-column label="图书状态" align="center" width="100">
                <template slot-scope="scope">
                    <el-tag v-if="scope.row.status === 0">上架</el-tag>
                    <el-tag v-if="scope.row.status === 1" type="info">下架</el-tag>
                </template>
            </el-table-column>
            <el-table-column prop="category.name" label="图书所属分类" align="center" width="120">
            </el-table-column>
            <el-table-column label="操作" width="300" align="center" fixed="right">
                <template slot-scope="scope">
                    <el-button type="text" icon="el-icon-edit"
                               @click="edit(scope.row.id, scope.row.name)"
                               style="color: #DCA550">修改
                    </el-button>
                    <el-button type="text" icon="el-icon-delete"
                               @click="removeBook(scope.row.id, scope.row.name)"
                               style="color:#E47370;">删除
                    </el-button>
                    <el-button type="text" v-if="scope.row.status === 0" icon="el-icon-bottom"
                               style="color: #919398"
                               @click="updateStatus(scope.row.id, scope.row.status, scope.row.name)">下架
                    </el-button>
                    <el-button type="text" v-else-if="scope.row.status === 1" icon="el-icon-top"
                               style="color: #5A9CF8"
                               @click="updateStatus(scope.row.id, scope.row.status, scope.row.name)">上架
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--分页栏-->
        <el-pagination :page-size.sync="pageSize" layout="total, sizes, prev, pager, next, jumper"
                       :total="total" :page-sizes="[5, 10, 15, 20, 25]" :current-page.sync="pageNum"
                       @current-change="getBooks"
                       @size-change="getBooks"></el-pagination>

    </div>

</template>
<!--和后端交互 使用axios-->
<script>
import axios from "axios";

export default {
    name: "book",
    created() { //当前组件只要实例化，自动调用
        axios.get("http://localhost:8888/books/page")
            .then(resp => {
                console.log(resp)
                this.books = resp.data.data.list;
                this.total = resp.data.data.total;
            })
    },
    data() {
        return {
            books: [],
            total: 0
        }
    }

}
</script>
<style>

</style>
