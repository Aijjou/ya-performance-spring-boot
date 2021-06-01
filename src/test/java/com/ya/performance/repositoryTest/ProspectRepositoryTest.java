package com.ya.performance.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ya.performance.entities.Prospect;
import com.ya.performance.repository.ProspectRepository;



/**
 * Unit test for PropectRepository 
 * @author Ahmed KECELI 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
class ProspectRepositoryTest {

	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	ProspectRepository repository;
	
	private Prospect prospect_test;
	
	private Prospect p1;
	private Prospect p2;
	private Prospect p3;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		prospect_test = new Prospect("M","nom","prenom","mail","phone", 
				"marié", 0, "1000", "lieu_habitation",true , true, true, "ville", "code_postal");
		
		p1 = new Prospect("M","nom#1","prenom#1","mail#1","0606060606", 
				"marié", 2, "1000", "IDF",true , true, true, "Paris", "75020");
		
		p2 = new Prospect("F","nom#2","prenom#2","mail#2","0202020202", 
				"marié", 0, "2700", "IDF",true , true, true, "Saint Denis", "93000");
		
		p3 = new Prospect("M","nom#3","prenom#3","mail#3","0303030303", 
				"marié", 0, "4000", "IDF",true , true, true, "Evry", "91000");
		

	}

	@Test
	@DisplayName("Should find no prospect if repo is empty ?")
	public void should_find_no_prospect_if_repo_empty() {
		Iterable<Prospect> prospects = repository.findAll();
		assertThat(prospects).isEmpty();
	}
	
	@Test
	@DisplayName("Should store a prospect ?")
	public void should_store_a_prospect() {
		Prospect prospect = repository.save(prospect_test);
		
		assertThat(prospect).hasFieldOrPropertyWithValue("prosCivilite", "M");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosNom", "nom");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosPrenom", "prenom");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosMail", "mail");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosPhone", "phone");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosSitFamilial", "marié");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosPersCharge", 0);
		assertThat(prospect).hasFieldOrPropertyWithValue("prosRevenuRef", "1000");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosLieuHab", "lieu_habitation");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosContact", true);
		assertThat(prospect).hasFieldOrPropertyWithValue("prosPromo", true);
		assertThat(prospect).hasFieldOrPropertyWithValue("prosCondition", true);
		assertThat(prospect).hasFieldOrPropertyWithValue("prosVille", "ville");
		assertThat(prospect).hasFieldOrPropertyWithValue("prosCode", "code_postal");

	}
	
	@Test
	@DisplayName("Should find all prospects ?")
	public void should_find_all_prospects() {
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		Iterable<Prospect> prospects = repository.findAll();
		assertThat(prospects).hasSizeGreaterThanOrEqualTo(3).contains(p1,p2,p3);
	}
	
	@Test
	@DisplayName("Should find prospect by Id ?")
	public void should_find_prospect_by_id() {
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		Prospect foundProspect = repository.findById(p1.getProsId()).get();
		assertThat(foundProspect).isEqualTo(p1);
	}
	
	@Test
	@DisplayName("Should uprdate prospect by Id")
	public void should_update_prospect_by_id() {
		entityManager.persist(p1);
		entityManager.persist(p2);
		
		Prospect updatedPros = new Prospect("M","update_nom","update_prenom","update_mail","phone", 
				"marié", 0, "1000", "lieu_habitation",true , true, true, "ville", "code_postal");
		
		Prospect p = repository.findById(p2.getProsId()).get();
		p.setProsNom(updatedPros.getProsNom());
		p.setProsPrenom(updatedPros.getProsPrenom());
		p.setProsMail(updatedPros.getProsMail());
		repository.save(p);
		
		Prospect checkPros = repository.findById(p2.getProsId()).get();
		
		assertThat(checkPros.getProsId()).isEqualTo(p2.getProsId());
		assertThat(checkPros.getProsNom()).isEqualTo(updatedPros.getProsNom());
		assertThat(checkPros.getProsPrenom()).isEqualTo(updatedPros.getProsPrenom());
		assertThat(checkPros.getProsMail()).isEqualTo(updatedPros.getProsMail());
	}
	
	
	
	@Test
	@DisplayName("Should delete prospect by Id ?")
	public void should_delete_prospect_by_id() {
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		repository.deleteById(p2.getProsId());
		Iterable<Prospect> prospects = repository.findAll();
		assertThat(prospects).hasSizeGreaterThanOrEqualTo(2).contains(p1,p3);
	}
	
	@Test
	@DisplayName("Should delete all prospect ?")
	public void should_delete_all_prospect() {
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}
	

}
