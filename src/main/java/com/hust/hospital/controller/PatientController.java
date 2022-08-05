package com.hust.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hust.hospital.dto.*;
import com.hust.hospital.entity.*;
import com.hust.hospital.entity.detail.*;
import com.hust.hospital.result.Result;
import com.hust.hospital.service.*;
import com.hust.hospital.util.IDUtils;
import com.hust.hospital.util.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * @author EdwardXu
 * @description 病人Controller层
 */
@RestController
public class PatientController {

    @Autowired
    private PatientService ps;

    @Autowired
    private InPathService ips;

    @Autowired
    private OverAllService oas;

    @Autowired
    private StageService ss;

    @Autowired
    private VariationService vs;
    /**
     * 展示所有病人
     *
     * @return
     */
    @RequestMapping(value = "/home/list", method = RequestMethod.GET)
    public Result<List<PatientDto>> getPatients() {

        List<Patient> patients = ps.getPatients();
        List<PatientDto> dtos = new ArrayList<>();
        for (Patient p : patients) {
            dtos.add(Transfer.patientToDto(p));
        }
        return Result.success(dtos);
    }

    /**
     * 展示在路径中的病人
     * @return
     */
    @RequestMapping(value = "/home/listf", method = RequestMethod.GET)
    public Result<List<InPathDto>> getInPaths() {
        List<InPath> patients = ips.getInPaths();
        List<InPathDto> dtos = new ArrayList<>();
        for (InPath p : patients) {
            dtos.add(Transfer.inPathToDto(p));
        }
        return Result.success(dtos);
    }

    @RequestMapping(value = "/addpat", method = RequestMethod.GET)
    public Result<Map<String, Object>> addPatient() {
        /**
         * 床位总数
         */
        final int countOfBed = 1000;
        Map<String,Object> map = new HashMap<>();
        String id;
        int bed = 0;
        LocalDate date = LocalDate.now();
        List<Integer> beds = ps.getBeds();
        for(int i = 1;i < countOfBed;i++){
            if(!beds.contains(i)){
                bed = i;
                break;
            }
            if(i == countOfBed - 1){
                map.put("message","床位已满");
                return Result.failed(map);
            }
        }
        id = IDUtils.getId();
        map.put("id",id);
        map.put("bed",bed);
        return Result.success(map);
    }
    @RequestMapping(value = "/addpat", method = RequestMethod.POST)
    public Result<Map<String, Object>> addPatient(@RequestBody AddPatientDto dto) {
        Map<String,Object> map = new HashMap<>();
        ps.addPatient(new Patient(dto.getId(),dto.getName(),dto.getBed(),Status.UNINVOLVED.getId()));
        map.put("message","成功加入");
        return Result.success(map);
    }


    
    /**
     * 将病人添加到路径
     * @return
     */
    @RequestMapping(value = "/home/addtopath", method = RequestMethod.POST)
    public Result<Map<String,Object>> addToPath(@RequestBody AddToPathDto dto) {

        String id = dto.getId();
        Patient p = ps.getPatientById(id);
        //status更改为执行中（1）
        InPath inPath = new InPath(p.getId(),p.getName(),p.getBed(),Status.OPERATING.getId(), LocalDate.parse(dto.getDate()), LocalTime.parse(dto.getTime()));
        p.setStatus(Status.OPERATING.getId());
        ps.updatePatient(p);
        ips.addInPath(inPath);
        Map<String, Object> map = new HashMap<>();
        //添加到stage1
        JSONObject ch= new JSONObject(dto.getCheckedCities());
        JSONObject ci = new JSONObject(dto.getCities());
        JSONObject de = new JSONObject(dto.getDetailCities());
        ss.addStage1(new Stage1(p.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),LocalDate.parse(dto.getDate()),LocalTime.parse(dto.getTime()),null,null));
        //添加到overall 将第一阶段改为正在进行

        oas.addOverAll(new OverAll(p.getId(),StageStatus.DOING.getId(),StageStatus.TODO.getId(),StageStatus.TODO.getId(),StageStatus.TODO.getId()));
        map.put("message","success");
        return Result.success(map);
    }


    @RequestMapping(value = "/path/overall", method = RequestMethod.GET)
    public Result<List<OverAllItemDto>> getOverAll(@RequestParam String id) {

        OverAll overAllById = oas.getOverAllById(id);
        List<OverAllItemDto> overAllItemDtos = Transfer.overAllToDtos(overAllById);
        return Result.success(overAllItemDtos);
    }


    /**
     * 查看病人某一阶段的详细信息
     * @param id    病人id
     * @param where 所处阶段
     * @return
     */
    @RequestMapping(value = "/path/scan", method = RequestMethod.GET)
    public Result<Map<String, Object>> pathScan(@RequestParam String id, @RequestParam int where) {

        Map<String, Object> map = new HashMap<>();
        if (where == Stage.ONE.getId()) {
            Stage1 stage1 = ss.getStage1ById(id);
            JSONObject checkedCities = JSON.parseObject(stage1.getCheckedCities());
            JSONObject cities = JSON.parseObject(stage1.getCities());
            JSONObject detailCities = JSON.parseObject(stage1.getDetailCities());
            //方便前端显示 需要转化
            Transfer.transferCheckedCities(checkedCities,cities);
            map.put("cities",cities);
            map.put("checkedCities", checkedCities);
            map.put("detailCities",detailCities);
            map.put("beginDate",stage1.getBeginDate());
            map.put("beginTime",stage1.getBeginTime());
            map.put("endDate",stage1.getEndDate());
            map.put("endTime",stage1.getEndTime());
        }else if (where == Stage.TWO.getId()){
            Stage2 stage2 = ss.getStage2ById(id);
            JSONObject checkedCities = JSON.parseObject(stage2.getCheckedCities());
            JSONObject cities = JSON.parseObject(stage2.getCities());
            JSONObject detailCities = JSON.parseObject(stage2.getDetailCities());
            Transfer.transferCheckedCities(checkedCities,cities);
            map.put("cities",cities);
            map.put("checkedCities", checkedCities);
            map.put("detailCities",detailCities);
            map.put("beginDate",stage2.getBeginDate());
            map.put("beginTime",stage2.getBeginTime());
            map.put("endDate",stage2.getEndDate());
            map.put("endTime",stage2.getEndTime());
        }else if (where == Stage.THREE.getId()){
            Stage3 stage3 = ss.getStage3ById(id);
            JSONObject checkedCities = JSON.parseObject(stage3.getCheckedCities());
            JSONObject cities = JSON.parseObject(stage3.getCities());
            JSONObject detailCities = JSON.parseObject(stage3.getDetailCities());
            Transfer.transferCheckedCities(checkedCities,cities);
            map.put("cities",cities);
            map.put("checkedCities", checkedCities);
            map.put("detailCities",detailCities);
            map.put("beginDate",stage3.getBeginDate());
            map.put("beginTime",stage3.getBeginTime());
            map.put("endDate",stage3.getEndDate());
            map.put("endTime",stage3.getEndTime());
        }else if (where == Stage.FOUR.getId()){
            Stage4 stage4 = ss.getStage4ById(id);
            JSONObject checkedCities = JSON.parseObject(stage4.getCheckedCities());
            JSONObject cities = JSON.parseObject(stage4.getCities());
            JSONObject detailCities = JSON.parseObject(stage4.getDetailCities());
            Transfer.transferCheckedCities(checkedCities,cities);
            map.put("cities",cities);
            map.put("checkedCities", checkedCities);
            map.put("detailCities",detailCities);
            map.put("beginDate",stage4.getBeginDate());
            map.put("beginTime",stage4.getBeginTime());
            map.put("endDate",stage4.getEndDate());
            map.put("endTime",stage4.getEndTime());
        }else {
            map.put("message","Failed!");
            return Result.failed(map);
        }
        return Result.success(map);
    }


    @RequestMapping(value = "/path/submit", method = RequestMethod.POST)
    public Result<Map<String, Object>> pathSubmit(@RequestBody StageDto dto){

        Map<String, Object> map = new HashMap<>();
        JSONObject ch= new JSONObject(dto.getCheckedCities());
        JSONObject ci = new JSONObject(dto.getCities());
        JSONObject de = new JSONObject(dto.getDetailCities());

        if (dto.getWhere() == Stage.ONE.getId()){
            Stage1 s = ss.getStage1ById(dto.getId());
            if (ss.getStage1ById(dto.getId()) != null){
                ss.updateStage1(new Stage1(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }else {
                ss.addStage1(new Stage1(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }
        }else if(dto.getWhere() == Stage.TWO.getId()){
            Stage2 s = ss.getStage2ById(dto.getId());
            if (ss.getStage2ById(dto.getId()) != null){
                ss.updateStage2(new Stage2(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }else {
                ss.addStage2(new Stage2(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }
        }else if(dto.getWhere() == Stage.THREE.getId()){
            Stage3 s = ss.getStage3ById(dto.getId());
            if (ss.getStage3ById(dto.getId()) != null){
                ss.updateStage3(new Stage3(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }else {
                ss.addStage3(new Stage3(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }
        }else if(dto.getWhere() == Stage.FOUR.getId()){
            Stage4 s = ss.getStage4ById(dto.getId());
            if (ss.getStage4ById(dto.getId()) != null){
                ss.updateStage4(new Stage4(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }else {
                ss.addStage4(new Stage4(dto.getId(),ch.toJSONString(),ci.toJSONString(),de.toJSONString(),s.getBeginDate(),s.getBeginTime(),s.getEndDate(),s.getEndTime()));
            }
        }else{
            map.put("message","failed!");
            return Result.failed(map);
        }
        map.put("message","success!");
        return Result.success(map);
    }

    @RequestMapping(value = "/evaluate/getprocess", method = RequestMethod.GET)
    public Result<Map<String, Object>> evaluateGetProcess(@RequestParam String id){

        OverAll oa = oas.getOverAllById(id);
        Map<String,Object> map = new HashMap<>();
        if(oa.getStageOne() == StageStatus.DOING.getId()){
            map.put("process",Stage.ONE.getId());
        }else if(oa.getStageTwo() == StageStatus.DOING.getId()){
            map.put("process",Stage.TWO.getId());
        }else if(oa.getStageThree() == StageStatus.DOING.getId()){
            map.put("process",Stage.THREE.getId());
        }else if(oa.getStageFour() == StageStatus.DOING.getId()){
            map.put("process",Stage.FOUR.getId());
        }else{
            map.put("message","ERROR!\n");
        }
        return Result.success(map);

    }


    @RequestMapping(value = "/evaluate", method = RequestMethod.POST)
    public Result<Map<String, Object>> evaluate(@RequestBody EvaluateDto dto){
        Map<String,Object> map = new HashMap<>();
        //proce == 0 继续本阶段
        //proce == 1 进入下一阶段
        //proce == 2 变异
        //proce == 3 完成路径
        switch (dto.getProce()){
            case 0: break;
            case 1: {
                //获取当前阶段
                int currentStage = dto.getStage();
                if(currentStage == Stage.ONE.getId()){
                    Stage1 s1 = ss.getStage1ById(dto.getId());
                    ss.updateStage1(new Stage1(s1.getPatientId(),s1.getCheckedCities(),s1.getCities(),s1.getDetailCities(),s1.getBeginDate(),s1.getBeginTime(),dto.getDate(),dto.getTime()));
                    ss.addStage2(new Stage2(dto.getId(),Stage2.getInitialCheckedCities(),Stage2.getInitialCities(),Stage2.getInitialDetailCities(),dto.getDate(),dto.getTime(),null,null));
                    OverAll oa = oas.getOverAllById(dto.getId());
                    oa.setStageOne(StageStatus.DONE.getId());
                    oa.setStageTwo(StageStatus.DOING.getId());
                    oas.updateOverAll(oa);
                }else if(currentStage == Stage.TWO.getId()){
                    Stage2 s2 = ss.getStage2ById(dto.getId());
                    ss.updateStage2(new Stage2(s2.getPatientId(),s2.getCheckedCities(),s2.getCities(),s2.getDetailCities(),s2.getBeginDate(),s2.getBeginTime(),dto.getDate(),dto.getTime()));
                    ss.addStage3(new Stage3(dto.getId(),Stage3.getInitialCheckedCities(),Stage3.getInitialCities(),Stage3.getInitialDetailCities(),dto.getDate(),dto.getTime(),null,null));
                    OverAll oa = oas.getOverAllById(dto.getId());
                    oa.setStageTwo(StageStatus.DONE.getId());
                    oa.setStageThree(StageStatus.DOING.getId());
                    oas.updateOverAll(oa);
                }else if(currentStage == Stage.THREE.getId()) {
                    Stage3 s3 = ss.getStage3ById(dto.getId());
                    ss.updateStage3(new Stage3(s3.getPatientId(), s3.getCheckedCities(), s3.getCities(), s3.getDetailCities(), s3.getBeginDate(), s3.getBeginTime(), dto.getDate(), dto.getTime()));
                    ss.addStage4(new Stage4(dto.getId(), Stage4.getInitialCheckedCities(), Stage4.getInitialCities(), Stage4.getInitialDetailCities(), dto.getDate(), dto.getTime(), null, null));
                    OverAll oa = oas.getOverAllById(dto.getId());
                    oa.setStageThree(StageStatus.DONE.getId());
                    oa.setStageFour(StageStatus.DOING.getId());
                    oas.updateOverAll(oa);
                }
                break;
            }
            case 3:{
                int currentStage = dto.getStage();
                OverAll oa = oas.getOverAllById(dto.getId());
                if(currentStage == Stage.ONE.getId()){
                    Stage1 s1 = ss.getStage1ById(dto.getId());
                    ss.updateStage1(new Stage1(s1.getPatientId(),s1.getCheckedCities(),s1.getCities(),s1.getDetailCities(),s1.getBeginDate(),s1.getBeginTime(),dto.getDate(),dto.getTime()));
                }else if(currentStage == Stage.TWO.getId()){
                    Stage2 s2 = ss.getStage2ById(dto.getId());
                    ss.updateStage2(new Stage2(s2.getPatientId(),s2.getCheckedCities(),s2.getCities(),s2.getDetailCities(),s2.getBeginDate(),s2.getBeginTime(),dto.getDate(),dto.getTime()));
                } else if(currentStage == Stage.THREE.getId()){
                    Stage3 s3 = ss.getStage3ById(dto.getId());
                    ss.updateStage3(new Stage3(s3.getPatientId(),s3.getCheckedCities(),s3.getCities(),s3.getDetailCities(),s3.getBeginDate(),s3.getBeginTime(),dto.getDate(),dto.getTime()));
                }else if(currentStage == Stage.FOUR.getId()) {
                    Stage4 s4 = ss.getStage4ById(dto.getId());
                    ss.updateStage4(new Stage4(s4.getPatientId(), s4.getCheckedCities(), s4.getCities(), s4.getDetailCities(), s4.getBeginDate(), s4.getBeginTime(), dto.getDate(), dto.getTime()));
                }
                oa.setStageOne(StageStatus.DONE.getId());
                oa.setStageTwo(StageStatus.DONE.getId());
                oa.setStageThree(StageStatus.DONE.getId());
                oa.setStageFour(StageStatus.DONE.getId());
                oas.updateOverAll(oa);
                InPath ip = ips.getInPathById(dto.getId());
                Patient p = ps.getPatientById(dto.getId());
                p.setStatus(Status.ENDED.getId());
                ip.setStatus(Status.ENDED.getId());
                ips.updateInPath(ip);
                ps.updatePatient(p);
                break;
            }
            case 2:{
                int currentStage = dto.getStage();
                OverAll oa = oas.getOverAllById(dto.getId());
                if(currentStage == Stage.ONE.getId()){
                    Stage1 s1 = ss.getStage1ById(dto.getId());
                    ss.updateStage1(new Stage1(s1.getPatientId(),s1.getCheckedCities(),s1.getCities(),s1.getDetailCities(),s1.getBeginDate(),s1.getBeginTime(),dto.getDate(),dto.getTime()));
                }else if(currentStage == Stage.TWO.getId()){
                    Stage2 s2 = ss.getStage2ById(dto.getId());
                    ss.updateStage2(new Stage2(s2.getPatientId(),s2.getCheckedCities(),s2.getCities(),s2.getDetailCities(),s2.getBeginDate(),s2.getBeginTime(),dto.getDate(),dto.getTime()));
                } else if(currentStage == Stage.THREE.getId()){
                    Stage3 s3 = ss.getStage3ById(dto.getId());
                    ss.updateStage3(new Stage3(s3.getPatientId(),s3.getCheckedCities(),s3.getCities(),s3.getDetailCities(),s3.getBeginDate(),s3.getBeginTime(),dto.getDate(),dto.getTime()));
                }else if(currentStage == Stage.FOUR.getId()) {
                    Stage4 s4 = ss.getStage4ById(dto.getId());
                    ss.updateStage4(new Stage4(s4.getPatientId(), s4.getCheckedCities(), s4.getCities(), s4.getDetailCities(), s4.getBeginDate(), s4.getBeginTime(), dto.getDate(), dto.getTime()));
                }
                oa.setStageOne(StageStatus.DONE.getId());
                oa.setStageTwo(StageStatus.DONE.getId());
                oa.setStageThree(StageStatus.DONE.getId());
                oa.setStageFour(StageStatus.DONE.getId());
                oas.updateOverAll(oa);
                Patient p = ps.getPatientById(dto.getId());
                InPath ip = ips.getInPathById(dto.getId());
                ip.setStatus(Status.MUTATED.getId());
                p.setStatus(Status.MUTATED.getId());
                ips.updateInPath(ip);
                ps.updatePatient(p);
                vs.addVariation(new Variation(dto.getId(),dto.getGround()));
                break;
            }
            default:{
                break;
            }
        }
        return Result.success(map);
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public Result<Map<String, Object>> getOut(@RequestParam String id) {
        Map<String,Object> map = new HashMap<>();
        Variation v = vs.getVariationById(id);
        if(v!=null){
            map.put("ground",v.getInfo());
            return Result.success(map);
        }else{
            map.put("message","failed!");
            return Result.failed(map);
        }

    }
}
