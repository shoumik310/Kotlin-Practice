fun main() { 
    val squareCabin = SquareCabin(6)
	val roundHut = RoundHut(3)
    val roundTower = RoundTower(4)
//     println("\nSquare Cabin\n============")
//     println("Capacity: ${squareCabin.capacity}")
//     println("Material: ${squareCabin.buildingMaterial}")
//     println("Has room? ${squareCabin.hasRoom()}")

    with(squareCabin) {
            println("\nSquare Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
        }
    
    with(roundHut) {
            println("\nRound Hut\n=========")
            println("Material: ${buildingMaterial}")
            println("Capacity: ${capacity}")
            println("Has room? ${hasRoom()}")
		}
    
   with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }
    
}

abstract class Dwelling(private var residents: Int){
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    fun hasRoom(): Boolean{
        return residents<capacity
    }
}

class SquareCabin(residents: Int): Dwelling(residents){
    override val buildingMaterial= "wood"
    override val capacity = 6
}

open class RoundHut(residents: Int): Dwelling(residents){
    override val buildingMaterial= "straw"
    override val capacity = 4
}

class RoundTower(
    residents: Int,
    val floors: Int =2
): RoundHut(residents){
    override val buildingMaterial = "stone"
    override val capacity = 4 * floors
}