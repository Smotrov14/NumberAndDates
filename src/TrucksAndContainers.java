public class TrucksAndContainers {
    private int box;
    private int containers;
    private int trucks;
    public TrucksAndContainers(int box) {
        this.box = box;
    }
    public int getTrucks() {
        return trucks;
    }
    public int getContainers() {
        return containers;
    }
    public int getBox() {
        return box;
    }

    public  void calculateInfo(){
        int containers= 0;
        int trucks = 0;
        if (box > 0){
            if( box%27 !=0){
                containers = box/27 +1;
                trucks =containers/12 +1;
            }
            else {
                containers = box/27;
                if(containers%12 !=0){
                    trucks =containers/12 +1;
                }
                else {
                    containers = box/27;
                    trucks =containers/12;
                }
            }
            this.containers =containers;
            this.trucks = trucks;
        }
    }
    public void printInfo(){
        calculateInfo();
        int boxPerContainer = this.box;
        int containerPerTruck=this.containers;
        int counter = 1;
        int containerCounter = 1;
        if(this.trucks == 0){
            System.out.println("Необходимо:" + System.lineSeparator() + "грузовиков - 0 шт." + System.lineSeparator() + "контейнеров - 0 шт.");
        }
        else {
            for(int i = 1; i <=this.trucks; i++) {
                System.out.print("Грузовик: " + i +System.lineSeparator());

                if(containerPerTruck>= 12){
                    for (int j = containerCounter; j < 12+containerCounter; j++) {
                        System.out.print("\tКонтейнер: " + j +System.lineSeparator());

                        if(boxPerContainer>=27) {
                            for (int k = counter; k < 27+counter; k++) {
                                System.out.print("\t\tЯщик: " + k + System.lineSeparator());
                            }
                            boxPerContainer -= 27;
                            counter += 27;
                        }
                        else{
                            for (int k = counter; k < counter + boxPerContainer; k++) {
                                System.out.print("\t\tЯщик: " + k + System.lineSeparator());
                            }
                        }
                    }
                    containerPerTruck -= 12;
                    containerCounter += 12;
                }
                else{
                    for (int j = containerCounter; j < containerCounter + containerPerTruck; j++) {
                        System.out.print("\tКонтейнер: " + j +System.lineSeparator());
                        if(boxPerContainer>=27) {
                            for (int k = counter; k < 27+counter; k++) {
                                System.out.print("\t\tЯщик: " + k + System.lineSeparator());
                            }
                            boxPerContainer -= 27;
                            counter += 27;
                        }
                        else{
                            for (int k = counter; k < counter + boxPerContainer; k++) {
                                System.out.print("\t\tЯщик: " + k + System.lineSeparator());
                            }
                        }

                    }
                }

            }
            System.out.println("Необходимо:" + System.lineSeparator() + "грузовиков - " + this.trucks +" шт." + System.lineSeparator() + "контейнеров - " + this.containers+" шт.");
        }
    }
}
