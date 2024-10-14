package com.TeamNull.LostArk.LostArk.repository;

import com.TeamNull.LostArk.LostArk.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Integer> {
}

/*
INSERT INTO data (id, Berserker, Destroyer, Gunlancer, Paladin, Slayer, Arcanist, Summoner, Bard, Sorceress, Wardancer, Scrapper, Soulfist, Glaivier, Striker, Breaker, Deathblade, Shadowhunter, Reaper, Soul_Eater, Sharpshooter, Deadeye, Artillerist, Aeromancer, Machinist, Gunslinger, Artist, created_at)
VALUES (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, NOW());
*/