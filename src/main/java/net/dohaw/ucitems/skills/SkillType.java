package net.dohaw.ucitems.skills;

import lombok.Getter;

public enum SkillType {

    FISHING(SkillCategory.WILD),
    MINING(SkillCategory.TRADE),
    LUMBERJACKING(SkillCategory.TRADE);

    @Getter private final SkillCategory category;
    SkillType(SkillCategory category){
        this.category = category;
    }

}
