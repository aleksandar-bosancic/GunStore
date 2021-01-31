package db.dao.mysql;

import db.dao.AirsoftRifleDAO;
import db.dto.AirsoftRifle;

import java.util.ArrayList;

public class AirsoftRifleDAOMySql implements AirsoftRifleDAO {
    @Override
    public ArrayList<AirsoftRifle> GetAll() {
        return null;
    }

    @Override
    public boolean createAirsoftRifle(AirsoftRifle AirsoftRifle) {
        return false;
    }

    @Override
    public AirsoftRifle readAirsoftRifle(int id) {
        return null;
    }

    @Override
    public boolean updateAirsoftRifle(AirsoftRifle AirsoftRifle) {
        return false;
    }

    @Override
    public boolean deleteAirsoftRifle(int id) {
        return false;
    }
}
