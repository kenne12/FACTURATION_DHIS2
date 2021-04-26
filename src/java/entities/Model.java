/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "model")
public class Model implements Serializable {

    @Id
    private Integer modelid;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Column(length = 50)
    private String type;

    @NotNull
    @Column(length = 60)
    private String titre;

    @Column(name = "declared_regex", length = 100, nullable = false)
    private String declaredRegex;

    @Column(name = "validated_regex", length = 100, nullable = false)
    private String validatedRegex;

    @Column(name = "percentage_error_regex", length = 100, nullable = false)
    private String percentageErrorRegex;

    @Column(name = "unit_price_regex", length = 100, nullable = false)
    private String unitPriceRegex;

    @Column(name = "total_amount_regex", length = 100, nullable = false)
    private String totalAmountRegex;

    @Column(name = "total1_regex", length = 100, nullable = false)
    private String total1Regex;

    @Column(name = "percentage_bonus_equite_regex", length = 100, nullable = false)
    private String percentageBonusEquiteRegex;

    @Column(name = "bonus_equite_regex", length = 100, nullable = false)
    private String bonusEquiteRegex;

    @Column(name = "total2_regex", length = 100, nullable = false)
    private String total2Regex;

    @Column(name = "quarterly_production_regex", length = 100, nullable = false)
    private String quarterlyProductionRegex;

    @Column(name = "tarrif_bonus_qualite_regex", length = 100, nullable = false)
    private String tarrifBonusQualiteRegex;

    @Column(name = "quarterly_bonus_qualite_regex", length = 100, nullable = false)
    private String quarterlyBonusQualiteRegex;

    @Column(name = "total3_regex", length = 100, nullable = false)
    private String total3Regex;

    @Column(name = "bonus_amelioration_qualite_regex", length = 100, nullable = false)
    private String bonusAmeliorationQualiteRegex;

    @Column(name = "total_general_regex", length = 100, nullable = false)
    private String totalGeneralRegex;

    @Column(name = "quality_assessment_weighted_score_regex", length = 100)
    private String qualityAssessmentWeightedScoreRegex;

    @Column(name = "quality_perceived_weighted_score_regex", length = 100)
    private String qualityPerceivedWeightedScoreRegex;

    @Column(name = "index_tool_weighted_score_regex", length = 100)
    private String indexToolWeightedScoreRegex;

    @Column(name = "global_quality_score_regex", length = 100)
    private String globalQualityScoreRegex;

    public Model() {
    }

    public Model(Integer modelid) {
        this.modelid = modelid;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeclaredRegex() {
        return declaredRegex;
    }

    public void setDeclaredRegex(String declaredRegex) {
        this.declaredRegex = declaredRegex;
    }

    public String getValidatedRegex() {
        return validatedRegex;
    }

    public void setValidatedRegex(String validatedRegex) {
        this.validatedRegex = validatedRegex;
    }

    public String getPercentageErrorRegex() {
        return percentageErrorRegex;
    }

    public void setPercentageErrorRegex(String percentageErrorRegex) {
        this.percentageErrorRegex = percentageErrorRegex;
    }

    public String getUnitPriceRegex() {
        return unitPriceRegex;
    }

    public void setUnitPriceRegex(String unitPriceRegex) {
        this.unitPriceRegex = unitPriceRegex;
    }

    public String getTotalAmountRegex() {
        return totalAmountRegex;
    }

    public void setTotalAmountRegex(String totalAmountRegex) {
        this.totalAmountRegex = totalAmountRegex;
    }

    public String getTotal1Regex() {
        return total1Regex;
    }

    public void setTotal1Regex(String total1Regex) {
        this.total1Regex = total1Regex;
    }

    public String getPercentageBonusEquiteRegex() {
        return percentageBonusEquiteRegex;
    }

    public void setPercentageBonusEquiteRegex(String percentageBonusEquiteRegex) {
        this.percentageBonusEquiteRegex = percentageBonusEquiteRegex;
    }

    public String getTotal2Regex() {
        return total2Regex;
    }

    public void setTotal2Regex(String total2Regex) {
        this.total2Regex = total2Regex;
    }

    public String getBonusEquiteRegex() {
        return bonusEquiteRegex;
    }

    public void setBonusEquiteRegex(String bonusEquiteRegex) {
        this.bonusEquiteRegex = bonusEquiteRegex;
    }

    public String getQuarterlyProductionRegex() {
        return quarterlyProductionRegex;
    }

    public void setQuarterlyProductionRegex(String quarterlyProductionRegex) {
        this.quarterlyProductionRegex = quarterlyProductionRegex;
    }

    public String getTotal3Regex() {
        return total3Regex;
    }

    public void setTotal3Regex(String total3Regex) {
        this.total3Regex = total3Regex;
    }

    public String getTotalGeneralRegex() {
        return totalGeneralRegex;
    }

    public void setTotalGeneralRegex(String totalGeneralRegex) {
        this.totalGeneralRegex = totalGeneralRegex;
    }

    public String getQuarterlyBonusQualiteRegex() {
        return quarterlyBonusQualiteRegex;
    }

    public void setQuarterlyBonusQualiteRegex(String quarterlyBonusQualiteRegex) {
        this.quarterlyBonusQualiteRegex = quarterlyBonusQualiteRegex;
    }

    public String getTarrifBonusQualiteRegex() {
        return tarrifBonusQualiteRegex;
    }

    public void setTarrifBonusQualiteRegex(String tarrifBonusQualiteRegex) {
        this.tarrifBonusQualiteRegex = tarrifBonusQualiteRegex;
    }

    public String getBonusAmeliorationQualiteRegex() {
        return bonusAmeliorationQualiteRegex;
    }

    public void setBonusAmeliorationQualiteRegex(String bonusAmeliorationQualiteRegex) {
        this.bonusAmeliorationQualiteRegex = bonusAmeliorationQualiteRegex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQualityAssessmentWeightedScoreRegex() {
        return qualityAssessmentWeightedScoreRegex;
    }

    public void setQualityAssessmentWeightedScoreRegex(String qualityAssessmentWeightedScoreRegex) {
        this.qualityAssessmentWeightedScoreRegex = qualityAssessmentWeightedScoreRegex;
    }

    public String getQualityPerceivedWeightedScoreRegex() {
        return qualityPerceivedWeightedScoreRegex;
    }

    public void setQualityPerceivedWeightedScoreRegex(String qualityPerceivedWeightedScoreRegex) {
        this.qualityPerceivedWeightedScoreRegex = qualityPerceivedWeightedScoreRegex;
    }

    public String getIndexToolWeightedScoreRegex() {
        return indexToolWeightedScoreRegex;
    }

    public void setIndexToolWeightedScoreRegex(String indexToolWeightedScoreRegex) {
        this.indexToolWeightedScoreRegex = indexToolWeightedScoreRegex;
    }

    public String getGlobalQualityScoreRegex() {
        return globalQualityScoreRegex;
    }

    public void setGlobalQualityScoreRegex(String globalQualityScoreRegex) {
        this.globalQualityScoreRegex = globalQualityScoreRegex;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.modelid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (!Objects.equals(this.modelid, other.modelid)) {
            return false;
        }
        return true;
    }

}
