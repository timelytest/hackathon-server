package com.timelytest.hackathon.controller;

import com.timelytest.hackathon.entity.Question;
import com.timelytest.hackathon.entity.User;
import com.timelytest.hackathon.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {
    private final RecommendService recommendService;
    @Autowired
    public RecommendController(RecommendService recommendService){
        this.recommendService=recommendService;
    }
    @PostMapping("/type")
    public List<String> getTypeList(){
        List<String> typeList = new ArrayList<>();
        typeList.add("Java");
        typeList.add("C++");
        typeList.add("微积分");
        typeList.add("线性代数");
        typeList.add("英语四级");
        typeList.add("英语六级");
        typeList.add("文学");
        typeList.add("法律");
        typeList.add("历史");

        return typeList;
    }

    @PostMapping("/topRewardUser/overall")
    // 返回全局累积获得积分最高的十个人
    public List<User> getTopRewordUserListOverall(){
        return recommendService.getTopRewordUserListOverall();
    }

    @PostMapping("/topRewardUser/locally")
    // 返回本地累积获得积分最高的十个人
    public List<User> getTopRewardUserListLocally(HttpSession session){
        return recommendService.getTopRewardUserListLocally(session.getAttribute("email").toString());
    }

    @PostMapping("/topResolvedQuestion")
    public List<Question> getLatestResolvedQuestionList(){
        return null;
    }

}
