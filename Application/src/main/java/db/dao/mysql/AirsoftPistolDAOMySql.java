package db.dao.mysql;

import db.dao.AirsoftPistolDAO;
import db.dto.AirsoftPistol;

import java.util.ArrayList;

public class AirsoftPistolDAOMySql implements AirsoftPistolDAO {
    @Override
    public ArrayList<AirsoftPistol> GetAll() {
        return null;
    }

    @Override
    public boolean createAirsoftPistol(AirsoftPistol AirsoftPistol) {
        return false;
    }

    @Override
    public AirsoftPistol readAirsoftPistol(int id) {
        return null;
    }

    @Override
    public boolean updateAirsoftPistol(AirsoftPistol AirsoftPistol) {
        return false;
    }

    @Override
    public boolean deleteAirsoftPistol(int id) {
        return false;
    }
}
