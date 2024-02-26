package com.uasz.DAOS_Microservice_Repartition.services;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.DAOS_Microservice_Repartition.models.Vacataire;
import com.uasz.DAOS_Microservice_Repartition.repositories.VacataireRepository;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@Data
public class VacataireService {
    @Autowired
    private VacataireRepository vacataireRepository;

    /**
     *  Methode ajouter un Vacataire
     * @param vacataire
     * @return vacataire
     */
    public Vacataire ajouterVac(Vacataire vacataire){
        return vacataireRepository.save(vacataire);

    }

    /**
     * Methode permettant de lister tous les Vacataires
     * @return {@code List<Vacataire>}
     */
    public List<Vacataire> listerToutVacataire(){
        return vacataireRepository.findAll();
    }

    /**
     * Methode permettant de trouver un vacataire de par son ID
     * @param idVac
     * @return {@code Optional} contenant le VACATAIRE trouve, ou {@code Optional.empty()} si aucun VACATAIRE est trouve;
     */
    public Optional<Vacataire> searchVac(Long idVac){
        return vacataireRepository.findById(idVac);
    }

    /**
     * Methode permettant de modifier un VACATAIRE
     * @param vacataire
     * @return {@Code VACATAIRE} la nouvelle VACATAIRE modifier ou, {@code new RuntimeException()} si le VACATAIRE n'existe pas
     */
    public Vacataire modifierEns(Vacataire vacataire){
        Optional<Vacataire> vacModif = searchVac(vacataire.getIdEns());
        if(vacModif.isPresent()) {
            vacModif.orElseThrow().setSpecialite(vacataire.getSpecialite());
            vacModif.orElseThrow().setNomEns(vacataire.getNomEns());
            vacModif.orElseThrow().setPrenomEns(vacataire.getPrenomEns());
            vacModif.orElseThrow().setGradeEns(vacataire.getGradeEns());
            return vacataireRepository.save(vacModif.get());
        }
        else{
            // Gérer le cas où le vacataire n'est pas trouvée
            throw new RuntimeException("VACATAIRE non trouvée avec l'ID : " + vacataire.getSpecialite());
        }

    }
    /**
     * Methode permettant de supprimer un Vacataire;
     *
     * @param id
     * @return
     */
    public void deleteVac(Long id){
        vacataireRepository.deleteById(id);
    }
}
