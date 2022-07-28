package got.helpers

interface DataService {
    fun createStartUpDataBase(serviceObjects: ServiceObjects)
    fun deleteAll()
}