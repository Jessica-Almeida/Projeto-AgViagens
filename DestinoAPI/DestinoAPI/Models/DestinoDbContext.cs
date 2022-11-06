﻿using Microsoft.EntityFrameworkCore;

namespace DestinoAPI.Models
{
   public class DestinoDbContext : DbContext
    {
        public DestinoDbContext(DbContextOptions<DestinoDbContext> options)
        : base(options)
        { }



        public DbSet<Destino> Destinos { get; set; }

        
    }
}
