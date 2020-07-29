package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;

import qin.com.entity.Classse;
import qin.com.entity.Department;
import qin.com.service.ClassseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/classse")
public class ClassseController {


    @Resource(name="classseServiceImpl")
    @Autowired
    private ClassseService classseService;

    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "classselist";
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(classseService.deleteByPrimaryKey(id)>0){
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
            if(classseService.deleteByList(deleteids)>0){
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
    public ServerResponse   insert(/*Classse record,*/ HttpServletRequest request, HttpServletResponse response) throws IOException {
        Classse classse=new Classse();
        classse.setName("zhangsan");

        if(classseService.insert(classse)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Classse record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName()+","+record.getMajorId()+","+record.getMajorName()+","+record.getStudentNumber());
        if(classseService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        Classse classse=classseService.selectByPrimaryKey(id);
        if(classse != null){
            return ServerResponse.createBySuccess(1,classse);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Classse record, HttpServletRequest request, HttpServletResponse response){
        if(classseService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Classse record, HttpServletRequest request, HttpServletResponse response){}


    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  listAll( HttpServletRequest request, HttpServletResponse response){

        List<Classse> classseList=classseService.selectAll();
        System.out.println("ok");
        if(classseList.size()>0){
            return ServerResponse.createBySuccess(classseList.size(),classseList);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
