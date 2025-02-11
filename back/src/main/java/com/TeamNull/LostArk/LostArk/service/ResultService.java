package com.TeamNull.LostArk.LostArk.service;

import com.TeamNull.LostArk.LostArk.Job.JobAttributes;
import com.TeamNull.LostArk.LostArk.Job.TopFactor;
import com.TeamNull.LostArk.LostArk.controller.dto.ResultDto;
import com.TeamNull.LostArk.LostArk.entity.Data;
import com.TeamNull.LostArk.LostArk.entity.Result;
import com.TeamNull.LostArk.LostArk.entity.User;
import com.TeamNull.LostArk.LostArk.repository.DataRepository;
import com.TeamNull.LostArk.LostArk.repository.ResultRepository;
import com.TeamNull.LostArk.LostArk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    private final DataRepository dataRepository;

    //직업별 성향치
    public List<JobAttributes> getAlljobAttributes() {
        return Arrays.asList(
                new JobAttributes("Destroyer",3,4,1,2,5, "bg-sky-300", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/destroyer.png"),
                new JobAttributes("Berserker",2,4,2,2,5, "bg-red-700", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/berserker.png"),
                new JobAttributes("Slayer",2,3,2,3,5, "bg-red-400", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/berserker_female.png"),
                new JobAttributes("Gunlancer",5,4,4,1,1, "bg-cyan-200", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/warlord.png"),
                new JobAttributes("Paladin",3,4,5,1,2, "bg-yellow-300", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/holyknight.png"),
                new JobAttributes("Soulfist",2,2,5,3,3, "bg-blue-400", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/soulmaster.png"),
                new JobAttributes("Wardancer",4,3,4,3,1, "bg-amber-500", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/battlemaster.png"),
                new JobAttributes("Breaker",2,2,4,4,3, "bg-amber-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/infighter_male.png"),
                new JobAttributes("Striker",2,2,4,5,2, "bg-amber-700", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/striker.png"),
                new JobAttributes("Scrapper",3,3,3,3,3, "bg-amber-800", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/infighter.png"),
                new JobAttributes("Glaivier",2,1,5,3,4, "bg-red-800", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/lancemaster.png"),
                new JobAttributes("Gunslinger",1,3,2,4,5, "bg-red-900", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/gunslinger.png"),
                new JobAttributes("Deadeye",1,3,1,5,5, "bg-cyan-800", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/devilhunter.png"),
                new JobAttributes("Artillerist",2,4,3,3,3, "bg-cyan-950", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/blaster.png"),
                new JobAttributes("Machinist",2,4,4,2,3, "bg-indigo-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/scouter.png"),
                new JobAttributes("Sharpshooter",2,3,3,4,3, "bg-blue-700" ,"https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/hawkeye.png"),
                new JobAttributes("Bard",4,5,4,1,1, "bg-amber-200", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/bard.png"),
                new JobAttributes("Summoner",3,3,3,4,2, "bg-blue-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/summoner.png"),
                new JobAttributes("Sorceress",2,3,2,5,3, "bg-rose-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/sorceress.png"),
                new JobAttributes("Arcanist",2,3,3,5,2, "bg-fuchsia-700", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/arcana.png"),
                new JobAttributes("Shadowhunter",3,3,2,2,5, "bg-red-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/demonic.png"),
                new JobAttributes("Reaper",2,2,1,5,5, "bg-green-600", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/reaper.png"),
                new JobAttributes("Deathblade",2,2,3,4,4, "bg-sky-300", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/blade.png"),
                new JobAttributes("Souleater",1,1,5,5,3, "bg-purple-800", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/soul_eater_s.png"),
                new JobAttributes("Aeromancer",4,3,4,2,2, "bg-rose-300", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/weather_artist.png"),
                new JobAttributes("Artist",4,4,4,2,1, "bg-rose-200", "https://cdn-lostark.game.onstove.com/2018/obt/assets/images/common/thumb/artist.png")
        );
    }

   @Transactional
    public void top5 (UUID id) {
       User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
//테스트 항목 평균값 계산
       double avg1 = (user.getQuestion1() + user.getQuestion2()) / 2.0;
       double avg2 = (user.getQuestion3() + user.getQuestion4()) / 2.0;
       double avg3 = (user.getQuestion5() + user.getQuestion6()) / 2.0;
       double avg4 = (user.getQuestion7() + user.getQuestion8()) / 2.0;
       double avg5 = (user.getQuestion9() + user.getQuestion10()) / 2.0;

       List<JobAttributes> results = getAlljobAttributes();
//각 성향별 점수 책정
       Map<JobAttributes, Double> jobScores = results.stream()
               .collect(Collectors.toMap(
                       job -> job,
                       job -> avg1 * job.getAgreeableness() +
                               avg2 * job.getConscientiousness() +
                               avg3 * job.getExtraversion() +
                               avg4 * job.getOpenness() +
                               avg5 * job.getNeuroticism()
               ));

////상위 5개 직업 선별
//       List<JobAttributes> top5Jobs = jobScores.entrySet().stream()
//               .sorted(Map.Entry.<JobAttributes, Double>comparingByValue().reversed())
//               .limit(5)
//               .map(Map.Entry::getKey)
//               .collect(Collectors.toList());
       List<TopFactor> top5Jobs = jobScores.entrySet().stream()
               .sorted(Map.Entry.<JobAttributes, Double>comparingByValue().reversed())
               .limit(5)
               .map(entry -> new TopFactor(entry.getKey().getJobName(), entry.getValue()))
               .collect(Collectors.toList());




       Result result = new Result();
       result.setUser(user);
//1위 부터 5위까지 저장
       result.setTopFactor1(top5Jobs.size() > 0 ? new TopFactor(top5Jobs.get(0).getJobName(), top5Jobs.get(0).getValue()) : null);
       result.setTopFactor2(top5Jobs.size() > 1 ? new TopFactor(top5Jobs.get(1).getJobName(), top5Jobs.get(1).getValue()) : null);
       result.setTopFactor3(top5Jobs.size() > 2 ? new TopFactor(top5Jobs.get(2).getJobName(), top5Jobs.get(2).getValue()) : null);
       result.setTopFactor4(top5Jobs.size() > 3 ? new TopFactor(top5Jobs.get(3).getJobName(), top5Jobs.get(3).getValue()) : null);
       result.setTopFactor5(top5Jobs.size() > 4 ? new TopFactor(top5Jobs.get(4).getJobName(), top5Jobs.get(4).getValue()) : null);

       resultRepository.save(result);

//Data 테이블 매핑
       Data data = dataRepository.findById(1).orElseThrow(()-> new IllegalArgumentException("Data not found"));
//저장될때마다 createdAt 갱신
       data.setCreatedAt(Timestamp.from(Instant.now()));
//1위 직업 카운트 1 증가
       switch (result.getTopFactor1().getJobName()) {
           case "Berserker":
               data.setBerserker(data.getBerserker() + 1);
               break;
           case "Destroyer":
               data.setDestroyer(data.getDestroyer() + 1);
               break;
           case "Gunlancer":
               data.setGunlancer(data.getGunlancer() + 1);
               break;
           case "Paladin":
               data.setPaladin(data.getPaladin() + 1);
               break;
           case "Slayer":
               data.setSlayer(data.getSlayer() + 1);
               break;
           case "Arcanist":
               data.setArcanist(data.getArcanist() + 1);
               break;
           case "Summoner":
               data.setSummoner(data.getSummoner() + 1);
               break;
           case "Bard":
               data.setBard(data.getBard() + 1);
               break;
           case "Sorceress":
               data.setSorceress(data.getSorceress() + 1);
               break;
           case "Wardancer":
               data.setWardancer(data.getWardancer() + 1);
               break;
           case "Scrapper":
               data.setScrapper(data.getScrapper() + 1);
               break;
           case "Soulfist":
               data.setSoulfist(data.getSoulfist() + 1);
               break;
           case "Glaivier":
               data.setGlaivier(data.getGlaivier() + 1);
               break;
           case "Striker":
               data.setStriker(data.getStriker() + 1);
               break;
           case "Deathblade":
               data.setDeathblade(data.getDeathblade() + 1);
               break;
           case "Shadowhunter":
               data.setShadowhunter(data.getShadowhunter() + 1);
               break;
           case "Reaper":
               data.setReaper(data.getReaper() + 1);
               break;
           case "Sharpshooter":
               data.setSharpshooter(data.getSharpshooter() + 1);
               break;
           case "Deadeye":
               data.setDeadeye(data.getDeadeye() + 1);
               break;
           case "Artillerist":
               data.setArtillerist(data.getArtillerist() + 1);
               break;
           case "Aeromancer":
               data.setAeromancer(data.getAeromancer() + 1);
               break;
           case "Machinist":
               data.setMachinist(data.getMachinist() + 1);
               break;
           case "Gunslinger":
               data.setGunslinger(data.getGunslinger() + 1);
               break;
           default:
               throw new IllegalArgumentException("Unknown job: " + result.getTopFactor1());
       }

       dataRepository.save(data);

   }

   // user UUID로 결과 반환
    public List<ResultDto> getResult(UUID id) {
        Result result = resultRepository.findByUserId(id).orElseThrow(() -> new IllegalArgumentException("result not found"));

        List<JobAttributes> jobAttributesList = getAlljobAttributes();

        List<ResultDto> resultDtoList = new ArrayList<>();

            resultDtoList.add(new ResultDto(result.getTopFactor1().getJobName(), result.getTopFactor1().getValue(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor1().getJobName())).findFirst().get().getIcon(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor1().getJobName())).findFirst().get().getColor()));
            resultDtoList.add(new ResultDto(result.getTopFactor2().getJobName(), result.getTopFactor2().getValue(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor2().getJobName())).findFirst().get().getIcon(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor2().getJobName())).findFirst().get().getColor()));
            resultDtoList.add(new ResultDto(result.getTopFactor3().getJobName(), result.getTopFactor3().getValue(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor3().getJobName())).findFirst().get().getIcon(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor3().getJobName())).findFirst().get().getColor()));
            resultDtoList.add(new ResultDto(result.getTopFactor4().getJobName(), result.getTopFactor4().getValue(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor4().getJobName())).findFirst().get().getIcon(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor4().getJobName())).findFirst().get().getColor()));
            resultDtoList.add(new ResultDto(result.getTopFactor5().getJobName(), result.getTopFactor5().getValue(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor5().getJobName())).findFirst().get().getIcon(),
                                        jobAttributesList.stream().filter(job -> job.getJobName().equals(result.getTopFactor5().getJobName())).findFirst().get().getColor()));

        return resultDtoList;
    }
}