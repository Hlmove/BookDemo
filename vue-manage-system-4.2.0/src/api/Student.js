import request from '../utils/request';

// Student的交互方法
// 查询
export const findAll = query => {
    return request({
        url: '/findAll',
        method: 'get',
        params: query
    });
};
// 添加

// 删除

// 修改
