package net.dohaw.ucitems.skills;

import net.dohaw.play.skills.skills.Skill;

public enum SkillType {

    FISHING(SkillCategory.WILD),
    MINING(SkillCategory.TRADE),
    LUMBERJACKING(SkillCategory.TRADE);

    private SkillCategory category;
    SkillType(SkillCategory category){
        this.category = category;
    }

}
