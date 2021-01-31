package db.dao;

import db.dto.AirsoftPistol;

import java.util.ArrayList;

public interface AirsoftPistolDAO {
    public ArrayList<AirsoftPistol> GetAll();
    public boolean createAirsoftPistol(AirsoftPistol AirsoftPistol);
    public AirsoftPistol readAirsoftPistol(int id);
    public boolean updateAirsoftPistol(AirsoftPistol AirsoftPistol);
    public boolean deleteAirsoftPistol(int id);
}
