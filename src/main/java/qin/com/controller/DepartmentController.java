package qin.com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;

import qin.com.entity.Department;
import qin.com.service.DepartmentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource(name="departmentServiceImpl")
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "departmentlist";
    }


    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(departmentService.deleteByPrimaryKey(id)>0){
            // response.getWriter().println("{\"status\":0,\"msg\":\"删除用户成功\"");
            return ServerResponse.createBySuccessMessage("删除用户成功");
        }else{
            //response.getWriter().println("{\"status\":1,\"msg\":\"删除用户失败\"");
            return ServerResponse.createByErrorMessage("删除用户失败");
        }

    }

    @RequestMapping("/deleteall")

    @ResponseBody

    public ServerResponse deleteall(String id){
        String[] deleteids=id.split(",");//把客户端传送过来的字符串（一般为“1，2，3，4”）转换成数组
        if(deleteids !=null && deleteids.length>0){
            if(departmentService.deleteByList(deleteids)>0){
                return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(),"删除管理员成功");
            }else{
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
            }
        }else{
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"删除数据失败");
        }
    }


    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   insert(/*Admin record,*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
        Department department=new Department();
        department.setName("zhangsan");
        department.setId(1);
        if(departmentService.insert(department)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Department record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName()+","+record.getId());
        if(departmentService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        Department department=departmentService.selectByPrimaryKey(id);
        if(department != null){
            return ServerResponse.createBySuccess(1,department);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Department record, HttpServletRequest request, HttpServletResponse response){
        if(departmentService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Department record, HttpServletRequest request, HttpServletResponse response){

    }
    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   listAll( HttpServletRequest request, HttpServletResponse response){

        List<Department> departmentList=departmentService.selectAll();
        System.out.println("ok");
        if(departmentList.size()>0){
            return ServerResponse.createBySuccess(departmentList.size(),departmentList);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }

}