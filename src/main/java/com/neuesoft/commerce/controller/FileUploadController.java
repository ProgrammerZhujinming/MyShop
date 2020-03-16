package com.neuesoft.commerce.controller;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.neuesoft.commerce.common.Resource;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.mapper.BrandMapper;
import com.neuesoft.commerce.pojo.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
 
@RestController
public class FileUploadController {
    private static  final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private BrandMapper brandMapper;
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";

    //上传图片

    @RequestMapping("/upload")
    @ResponseBody
    public Result uploadFile(MultipartFile file, String bname, String cid) throws IOException {

        Result result = new Result();

        try {
            //获取文件名
            String fileName = file.getOriginalFilename();
            //保存图片的路径
            String filePath = "F:/QQReserve/myshop/src/main/resources/static/image/";
            File dest = new File(filePath + fileName);
            //保存图片
            file.transferTo(dest);
            System.out.println(fileName);
            Brand brand = new Brand();
            brand.setBname(bname);
            brand.setBlogo(fileName);
            int id = Integer.parseInt(cid);
            brand.setCid(id);
            //插入
            brandMapper.insertBrand(brand);
            result.setCode(Resource.SUCCESS);
            result.setMsg("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    @RequestMapping("/uploada")
    public String upload(@RequestParam(value = "file",required=false)MultipartFile uploadFile, HttpServletRequest request){
        if(uploadFile.isEmpty()){
            //返回选择文件提示
            return "请选择上传文件";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/uploadFile/";//核心！！！！上传到编译路径
        //String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            String resPath = "/uploadFile/" + format + newName;
            logger.info("-----------【"+ filePath +"】-----------");
            return resPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }
 
 
}
