package qin.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qin.com.common.ResponseCode;
import qin.com.common.ServerResponse;

import qin.com.entity.Major;
import qin.com.service.MajorService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller()
@RequestMapping("/major")
public class MajorController {
    @Resource(name="majorServiceImpl")
    @Autowired
    private MajorService majorService;

    @RequestMapping("/index")
    public String index(){
        return "adminindex";
    }

    @RequestMapping("/list")
    public String list(){
        return "majorlist";
    }


    @RequestMapping(value = "/deleteByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse deleteByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(majorService.deleteByPrimaryKey(id)>0){
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
            if(majorService.deleteByList(deleteids)>0){
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
        Major major=new Major();
        major.setName("zhangsan");
        major.setId(1);
        if(majorService.insert(major)>0){
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }else{
            return ServerResponse.createByErrorMessage("添加用户失败");
        }
    }


    @RequestMapping(value = "/insertSelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  insertSelective(Major record, HttpServletRequest request, HttpServletResponse response){
        System.out.println(record.getName()+","+record.getId());
        if(majorService.insert(record)>0){
            return ServerResponse.createBySuccessMessage("添加数据成功");
        }else{
            return ServerResponse.createByErrorMessage("添加数据失败");
        }
    }


    @RequestMapping(value = "/selectByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse   selectByPrimaryKey(Integer id, HttpServletRequest request, HttpServletResponse response){
        Major major=majorService.selectByPrimaryKey(id);
        if(major != null){
            return ServerResponse.createBySuccess(1,major);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKeySelective",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse updateByPrimaryKeySelective(Major record, HttpServletRequest request, HttpServletResponse response){
        if(majorService.updateByPrimaryKeySelective(record)>0){
            return ServerResponse.createBySuccessMessage("更新数据成功");
        }else{
            return ServerResponse.createByErrorMessage("更新数据失败");
        }
    }


    @RequestMapping(value = "/updateByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void  updateByPrimaryKey(Major record, HttpServletRequest request, HttpServletResponse response){

    }
    @RequestMapping(value = "/listAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ServerResponse  listAll( HttpServletRequest request, HttpServletResponse response){

        List<Major> majorList=majorService.selectAll();
        System.out.println("ok");
        if(majorList.size()>0){
            return ServerResponse.createBySuccess(majorList.size(),majorList);
        }else{
            return ServerResponse.createByErrorMessage("没有找到用户");
        }
    }
}
