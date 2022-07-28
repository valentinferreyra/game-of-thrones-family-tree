package got.helpers

import got.model.Character
import got.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class DataServiceImpl : DataService {

    @Autowired lateinit var characterService: CharacterService

    override fun createStartUpDataBase(serviceObjects: ServiceObjects) {
        characterService.saveCharacter(serviceObjects.viserysTargaryen)
        characterService.saveCharacter(serviceObjects.daenerysTargaryen)
        characterService.saveCharacter(serviceObjects.rhaegarTargaryen)
        characterService.saveCharacter(serviceObjects.jonSnow)
        characterService.saveCharacter(serviceObjects.lyannaStark)
        characterService.saveCharacter(serviceObjects.sansaStark)
        characterService.saveCharacter(serviceObjects.rickonStark)
        characterService.saveCharacter(serviceObjects.aryaStark)
        characterService.saveCharacter(serviceObjects.branStark)
        characterService.saveCharacter(serviceObjects.robStark)
        characterService.saveCharacter(serviceObjects.nedStark)
        characterService.saveCharacter(serviceObjects.catellynTully)
    }

    override fun deleteAll() {
        characterService.deleteAll()
    }

}